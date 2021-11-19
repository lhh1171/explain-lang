package com.company;

import java.io.*;

class MyWord{
    String word;
    int index;
}

public class ReadTools {
    static MyWord[] words=new MyWord[20];
    static int count=0;
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
            } else {
                stringBuilder.append(analyseWord(str,MyWordTree.head));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public void insertWord(String word,int index){
        for (int i = 0; i < 20; i++) {
            if (words[i]==null){
                words[i]=new MyWord();
                words[i].word=word;
                words[i].index=index;
                break;
            }
        }
    }

    private   boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    String analyseWord(String string,MyWordTreeNode t){
        StringBuilder stringBuilder=new StringBuilder();
        MyWordTreeNode temp=t;
        for (char c:string.toCharArray()){
            if (temp.left[0]==null){
                return getString(string);
            }else {
                for (MyWordTreeNode node:temp.left){
                    if (node==null){
                        //别把所有的空间用完
                        return getString(string);
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
            return getString(string);
        }
    }

    private String getString(String string) {
        if (isNumeric(string)){
            return "88:"+string;
        }else {
            for (MyWord word:words){
                if (word==null){
                    break;
                }else if (string.equals(word.word)){
                    return "88:"+word.index+"x";
                }
            }
            count++;
            insertWord(string,count);
            return "88:"+count+"x";
        }
    }
}
