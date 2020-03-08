package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CatCommand extends Command {
    CatCommand(String []_args , String _path){
        args = _args;
        mPath = _path;
    }
    protected boolean check(){

        return ((FileExist(args[0]) || FileExist(mPath +'/' + args[0]))) && args.length ==1;
    }
    protected void run(String path) {
        mPath = toAbsolutePath(path);
        if (check()){
            try (BufferedReader br = new BufferedReader(new FileReader(fileToProcess()))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else  {
            System.out.println("Too much arguments");

        }

    }
    String fileToProcess(){ /// we checked the file name before , so we have 2 cases short or complete path

        if(FileExist(args[0]))
            return args[0];
        return mPath +'/' + args[0];
    }
    public void ShowArguments(){/// todo

    }
}
