package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        MyWordTree myWordTree=new MyWordTree();
        ReadTools readTools=new ReadTools();
        WriteTools writeTools=new WriteTools();
        myWordTree.createWordTree();
        String s = readTools.executeFile(args[0]);
        writeTools.write(s,args[1]);
        System.out.println(s);
    }
}