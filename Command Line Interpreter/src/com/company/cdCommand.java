package com.company;

/// todo

import java.nio.file.Path;
import java.nio.file.Paths;

/** done with the short path and long path
 *  todo handle the cd ..
 *
 */
public class cdCommand extends Command {

    cdCommand(String [] _args , String _path){
        args = new String[_args.length];
        for (int i = 0 ; i <args.length ; ++i )
            args[i] = _args[i];
        mPath = _path;
    }
    public boolean check(){/// todo
        return  (DirectoryExist(args[0]) || DirectoryExist(mPath +'/' + args[0]))  &&  args.length==1;
    }
    public void run(String _path){ /// todo redundant path
        args[0] = toAbsolutePath(args[0]);
        Path p = Paths.get(args[0]);
            if(p.toFile().isDirectory()){
                mPath = args[0];
            }
            else {
                mPath = _path + '/' + args[0];
            }
            //TODO: Handle wring number of arguments
        return;
    }
    public String changeDirectory(){
        this.run(mPath);
        return this.mPath;
    }
}
