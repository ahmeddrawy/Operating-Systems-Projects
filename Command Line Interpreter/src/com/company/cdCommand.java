package com.company;
import java.nio.file.Path;
import java.nio.file.Paths;

/** done with the short path and long path
 *  handle the cd ..  done
 *
 */
public class cdCommand extends Command {

    cdCommand(String [] _args , String _path){
        args = new String[_args.length];
        for (int i = 0 ; i <args.length ; ++i )
            args[i] = _args[i];
        TerminalPath  = Paths.get(_path);
        myPath  = Paths.get(_path);
    }
    cdCommand(String [] _args , Path _path){
        args = new String[_args.length];
        for (int i = 0 ; i <args.length ; ++i )
            args[i] = _args[i];
//        mPath = _path;
        TerminalPath = _path;
        myPath = _path;

    }
    public boolean check(){/// todo
        return  DirectoryExist(myPath) &&  args.length==1;
    }
    public void run(String _path){ /// todo redundant path
        args[0] = toAbsolutePath(args[0]);
        myPath  = Paths.get(args[0]);
        if(!check()){   /// if error return my path to the terminal path
            myPath =   TerminalPath;
        }

//            if(p.toFile().isDirectory()){
//                mPath = args[0];
//            }
//            else {
//                mPath = _path + '/' + args[0];
//            }
            //TODO: Handle wring number of arguments
        return;
    }
    public String changeDirectory(){
        this.run(mPath);
        return this.mPath;
    }
    public void ShowArguments(){/// todo

    }
}
