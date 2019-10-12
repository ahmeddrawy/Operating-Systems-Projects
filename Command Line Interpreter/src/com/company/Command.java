package com.company;

import java.io.File;

public abstract class Command {
     protected abstract boolean check(String[] args);
    protected abstract void run(String path);
    protected boolean FileExist(String path){
        File tmpFile = new File(path);
        return tmpFile.exists() && tmpFile.isFile();
    }
    protected boolean DirectoryExist(String path){  /// todo handle the short path
        File tmpFile = new File(path);
        return tmpFile.exists() && tmpFile.isDirectory();

    }

}
