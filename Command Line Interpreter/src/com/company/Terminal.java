package com.company;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;
/** todo help function for every command - take care of commands with no class
 *  todo operator | < >
 *  todo args ,  rm ,more
 *
  */

public class Terminal {
    private String CurrentPath  = null;
    private String HomePath = "/home/tw3" ; /// todo current home on my machine , if you gonna try it with another machine you have to change it
    MyParser terminalParser ;
    String[]ListOfCommands = {"cd"};
    Terminal(){
        terminalParser = new MyParser();
        CurrentPath = HomePath;
        while (true)
        PromptForCommands();

    }
    Terminal(String path){
        CurrentPath = path  ;
        while(true)
            PromptForCommands();

    }
    private void PromptForCommands(){
        if(CurrentPath == null || CurrentPath.compareTo(HomePath) ==0)
            System.out.print("Hanfy'sPC:~$ ");
        else
            System.out.print("Hanfy'sPC:~"+CurrentPath + " $ ");
        Scanner s = new Scanner(System.in);
        String cmd =  s.nextLine();

        terminalParser.parse(cmd);
        runCommand();
    }
    public void runCommand(){
        String cmd = terminalParser.cmd;
        if( terminalParser.cmd.compareTo("cd") == 0){
           cdCommand c = new cdCommand(terminalParser.args , CurrentPath);
            CurrentPath = c.changeDirectory();
        }
        else if( terminalParser.cmd.compareTo("pwd") == 0)
           pwd();
        else if(cmd.compareTo("ls") == 0){
           lsCommand l = new lsCommand(terminalParser.args , CurrentPath);
           l.run(CurrentPath);
        }
        else if(cmd.compareTo("cat") == 0){
           CatCommand c = new CatCommand(terminalParser.args , CurrentPath);
           c.run(CurrentPath);
        }
        else if(cmd.compareTo("date") == 0){
            Date d = new Date();
            System.out.println  (d);
        }
        else if(cmd.compareTo("mkdir") ==0 ){
            mkdirCommand c  = new mkdirCommand(Paths.get(CurrentPath) ,terminalParser.args );
            c.run(CurrentPath);
        }
        else if(cmd.compareTo("exit") == 0){
           System.exit(1);
        }

        else {
            System.out.println(terminalParser.cmd +" command not found ");

        }
    }


    void pwd(){ /// todo check the parameters size
        if(terminalParser.args.length >0){
            System.out.println("Too much arguments" );
        }
        else
            System.out.println(CurrentPath);
    }
}
