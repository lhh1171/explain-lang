package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
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
        }
    }
}
