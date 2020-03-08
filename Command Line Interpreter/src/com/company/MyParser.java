package com.company;

import java.util.Vector;

public class MyParser {
    String[] args; // Will be filled by arguments extracted by parse method
    String cmd; //

    public MyParser(){
        cmd = null ;
    }
    public boolean parse (String input){/// todo chech if command exist
        if(input == null)
            return false ; /// todo check when we return false from parsing
        String [] res  = input.split(" ");
        cmd = res[0];
        args = new String[res.length -1];
        for (int i = 1; i < res.length; ++i )
            args[i-1]= res[i];
        return true ;///todo remove later

    }
    public String getCmd(){
        return cmd ;
    }
}
