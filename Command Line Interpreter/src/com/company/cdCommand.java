package com.company;

import com.company.Command;

public class cmdCommand extends Command {
    public boolean check(String[] args){/// todo
        return  DirectoryExist(args[0]);
    }
    public void run(String path){ /// todo
        System.out.println("HEY");
        return;
    }
}
