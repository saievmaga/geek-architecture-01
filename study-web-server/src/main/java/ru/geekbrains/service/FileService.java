package ru.geekbrains.service;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.config.Init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class FileService {

    private final String rootPath;

    public FileService() {
        this.rootPath = Init.getROOT_PATH();
    }

    public boolean fileIsExist(String requiredPath) {
        Path path = Paths.get(rootPath, requiredPath);
        return Files.exists(path);
    }

    public String getFile(String requiredPath) {
        Path path = Paths.get(rootPath, requiredPath);
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        return strings.toString();
    }

    public void createFileAndWriteBody(String requiredPath, String body) {
        File file = new File(rootPath, requiredPath.concat(".txt"));
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(body);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}