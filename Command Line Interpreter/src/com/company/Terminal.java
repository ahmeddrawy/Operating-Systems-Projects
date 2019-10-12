package com.company;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.util.Scanner;

public class Terminal {
    private String CurrentPath  = null;
    private String HomePath = "/home/tw3" ; /// todo current home on my machine , if you gonna try it with another machine you have to change it
    MyParser terminalParser ;
    Terminal(){
        terminalParser = new MyParser();
        PromoptForCommands();

    }
    Terminal(String path){
        CurrentPath = path  ;
        PromoptForCommands();

    }
    private void PromoptForCommands(){
        if(CurrentPath == null || CurrentPath.compareTo(HomePath) ==0)
            System.out.print("Hanfy'sPC:~$ ");
        else
            System.out.print("Hanfy'sPC:~"+CurrentPath + "$ ");
        Scanner s = new Scanner(System.in);
        String cmd =  s.nextLine();

        terminalParser.parse(cmd);
        runCommand();
    }
    public void runCommand(){
        Command c ;
        if( terminalParser.cmd.compareTo("cd") == 0){
            c = new cmdCommand();

            System.out.println( c.check(terminalParser.args));
        }
    }


    void pwd(){
        System.out.println(CurrentPath);
    }
}
