package com.saiev.composite;

import java.nio.file.Path;

public class MyFile implements MyFileInterface {

    private final String path;

    private long size;


    private boolean isFile;

    public MyFile(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
        Path path1 = Path.of(path);
        size = path1.toFile().length();
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getChildren() {
        return "";
    }


    @Override
    public boolean isFile() {

        return isFile;
    }
}