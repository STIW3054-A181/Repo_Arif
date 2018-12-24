package com.mavenproject.rtproject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public interface AccessFilesInterface {
    
    public void downloadZip(URL url, File file);
    public void unzip(String zipFile);
    public ArrayList<String> listFiles();
    public ArrayList<String> readFiles(ArrayList<String> listFiles);
    
}
