package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Command {
    String []args ;
    String mPath;

    String toAbsolutePath(String p){
        Path path = Paths.get(p);
        if(!path.toFile().isAbsolute()) {
            path = Paths.get(mPath + File.separatorChar + p);
        }
        return path.normalize().toAbsolutePath().toString();
    }

    protected abstract boolean check();
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
