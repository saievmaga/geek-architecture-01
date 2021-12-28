package com.saiev.system_patterns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper {

    private final Connection conn;

    private  PreparedStatement preparedStatement;

    private final Map<Long, User> identityMap = new HashMap<>();

    public UserMapper(Connection conn) {
        this.conn = conn;
    }

    public Optional<User> findById(long id) {
        User user = identityMap.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        try {
            this.preparedStatement = conn.prepareStatement("select id, username, password from users where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
                identityMap.put(id, user);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.empty();
    }

    public void update(User user) {
        try {
            this.preparedStatement = conn.prepareStatement("update username, password from users where id = ?");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void insert(User user) {
        try {
            this.preparedStatement = conn.prepareStatement("insert into users values (id=?, username=?, password=?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public void delete(User user) {
        try {
            this.preparedStatement = conn.prepareStatement("delete from users where id=?");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}