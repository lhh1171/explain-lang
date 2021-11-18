package com.company;

import java.io.*;

public class ReadTools {
    String executeFile(String path) throws IOException {
        return analyseWords(splitFile(path));
    }

    byte[] readFile(String path) throws IOException {
        File file=new File(path);
        InputStream fis=new FileInputStream(file);
        //OutputStream fos=new FileOutputStream(file);
        StringBuilder s= null;
        byte[] buffer=new byte[10240];
        fis.read(buffer);
        fis.close();
        return buffer;
    }

    String[] splitFile(String path) throws IOException {
        StringBuilder stringBuilder=new StringBuilder();
        byte[] bytes = readFile(path);
        for (byte i:bytes){
            stringBuilder.append((char)i);
        }
        return stringBuilder.toString().split(" ");
    }

    String analyseWords(String[] strings){
        StringBuilder stringBuilder=new StringBuilder();
        String[] splits;
        String s;
        for (String str:strings){
            if (str.contains("\n")){
                splits=str.split("\n");
                for (String string:splits){
                    stringBuilder.append(analyseWord(string,MyWordTree.head));
                    stringBuilder.append("\n");
                }
                s=stringBuilder.toString();
                s = s.substring(0, s.length() - 1);
                stringBuilder=new StringBuilder(s);
                stringBuilder.append(" ");
            } else {
                stringBuilder.append(analyseWord(str,MyWordTree.head));
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    String analyseWord(String string,MyWordTreeNode t){
        StringBuilder stringBuilder=new StringBuilder();
        MyWordTreeNode temp=t;
        for (char c:string.toCharArray()){
            if (temp.left[0]==null){
                return "88";
            }else {
                for (MyWordTreeNode node:temp.left){
                    if (node==null){
                        //别把所有的空间用完
                        return "88";
                    } else {
                        if (node.k==c){
                            temp=node;
                            break;
                        }
                    }
                }
            }
        }
        if (temp.no!=0){
            return stringBuilder.append(temp.no).toString();
        }else {
            return "88";
        }
    }
}
