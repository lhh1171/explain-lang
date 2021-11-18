package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        MyWordTree myWordTree=new MyWordTree();
        ReadTools readTools=new ReadTools();
        WriteTools writeTools=new WriteTools();
        myWordTree.createWordTree();
        String s = readTools.executeFile("/opt/ff/a.txt");
        File file= writeTools.write(s,"/opt/ff/out.txt");
        System.out.println(s);
    }
}




//        for (String str:strings){
//            System.out.print(str);
//        }
/*
 String path=args[0];
        File file=new File(path);
        InputStream fis=new FileInputStream(file);
        //OutputStream fos=new FileOutputStream(file);
        StringBuilder s= null;
        byte[] buffer=new byte[10240];
        fis.read(buffer);
        for (byte b : buffer) {
            if (s == null) {
                s = new StringBuilder("" + (char) b);
            } else if (b != 0) {
                s.append((char) b);
            }
        }
        for (int i: s.toString().toCharArray()){
            System.out.println((int)i);
        }*/