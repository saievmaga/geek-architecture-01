package com.saiev.composite;

import java.nio.file.Path;
import java.util.ArrayList;

public class FilePackage {

    private ArrayList<MyFileInterface> myFiles;

    public FilePackage(String rootUrl) {
        ArrayList<MyFileInterface> arrayList = new ArrayList<>();
        Path path = Path.of(rootUrl);
        java.io.File file = path.toFile();
        java.io.File[] files = file.listFiles();
        for (java.io.File file1 : files) {
            if (file1.isDirectory()) {
                arrayList.add(new MyFile(file1.getPath(), file.isFile()));
            } else {
                arrayList.add(new MyPath(file1.getPath(), file.isFile()));
            }
        }
        System.out.println("___________");
        System.out.println(arrayList.size());
        System.out.println("___________");
        System.out.println(arrayList);
        System.out.println("___________");
        myFiles = arrayList;
    }

    public double averageSize() {
        double count = 0;
        double average = 0;
        for (MyFileInterface file : myFiles) {
            if (!file.isFile()) {
                average += file.getSize();
                count++;
            }
        }
        return average / count;
    }
}