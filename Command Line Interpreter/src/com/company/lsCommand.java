package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
/// todo handle the -1 option and no options print next to each other
public class lsCommand extends Command {

    lsCommand(String []_args , String _path ){
        args = new String[_args.length];
        for (int i = 0 ; i <args.length ; ++i )
            args[i] = _args[i];
        mPath = _path;
    }
    protected  boolean check( ){
        return true;
    }
    protected  void run(String path){
        File f = new File(path);
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        for (String s:names) {
            System.out.println(s);
        }
    }
}
