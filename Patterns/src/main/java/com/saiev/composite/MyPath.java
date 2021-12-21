package com.saiev.composite;

public class MyPath implements MyFileInterface{

    private String path;

    private int size;

    private String children;

    private boolean isFile;

    public MyPath(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setSize(int size) {
        this.size= size;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public String getChildren() {
        return children;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}