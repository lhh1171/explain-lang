package com.company;

import java.util.Scanner;

class MyWordTree {
    MyWordTreeNode head;
    MyWordTreeNode temp;
    Scanner sc=new Scanner(System.in);
    int flag;
    String a;
    int b;
    void createWordTree() {
        System.out.println("请输入1继续");
        flag=sc.nextInt();
        while (flag==1){
            System.out.println("请输入关键词和两位数编号");
            a=sc.next();
            b= sc.nextInt();
            setWord(a,b,head);
            System.out.println("请输入1继续");
            flag=sc.nextInt();
        }
    }
    public  String deleteStr(String str, char delChar){
        String delStr = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != delChar){
                delStr += str.charAt(i);
            }
        }
        return delStr;
    }
    void setWord(String s,int ma,MyWordTreeNode t){
        MyWordTreeNode temp=t;
        MyWordTreeNode tail;
        for (char a:s.toCharArray()){
            for (MyWordTreeNode tt: temp.left){
                if (a==tt.k){
                    temp=tt;
                    s=deleteStr(s,a);
                }else {
                    temp=chooseNode(temp);
                    tail= toBeList(temp,s);
                    break;
                }
            }
            break;
        }
    }

    MyWordTreeNode chooseNode(MyWordTreeNode yy){
        return null;
    }

    MyWordTreeNode toBeList(MyWordTreeNode mm,String s){
        return null;
    }

}
