package com.company;

import java.util.Scanner;

class MyWordTree {
    static MyWordTreeNode head=new MyWordTreeNode();
    Scanner sc=new Scanner(System.in);
    int flag;
    String a;
    int b;

    void createWordTree() {
        System.out.println("请输入1继续");
        flag=sc.nextInt();
        head.no=99;
        head.k='R';
        while (flag==1){
            System.out.println("请输入关键词");
            a=sc.next();
            System.out.println("请输入编号(两位数)");
            b= sc.nextInt();
            setWord(a,b,head);
            System.out.println("请输入1继续");
            flag=sc.nextInt();
        }
        sc.close();
    }

    String deleteStr(String str, char delChar){
        StringBuilder delStr = new StringBuilder();
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (count==0){
                if (str.charAt(i)==delChar){
                    count++;
                }else {
                    delStr.append(str.charAt(i));
                }
            }else {
                delStr.append(str.charAt(i));
            }
        }
        return delStr.toString();
    }

    void setWord(String s,int ma,MyWordTreeNode head){
        String ts=s;
        MyWordTreeNode tail = null;
        MyWordTreeNode temp;
        temp=head;
        if (head.left[0]==null){
            tail=toBeList(head,s);
            tail.no=ma;
        }else {
            for (char a:ts.toCharArray()){
                for (MyWordTreeNode tt: temp.left){
                    if (a==tt.k){
                        ts=deleteStr(ts,a);
                        temp=tt;
                    }else {
                        tail= toBeList(temp,ts);
                        tail.no=ma;
                    }
                    break;
                }
                if (tail!=null){
                    break;
                }
            }
        }
    }

    int chooseNode(MyWordTreeNode yy){
        for (int i = 0; i < 20; i++) {
            if (yy.left[i]==null){
                return i;
            }
        }
        return -1;
    }

    MyWordTreeNode toBeList(MyWordTreeNode mm,String s){
        MyWordTreeNode tail = new MyWordTreeNode();
        mm.left[chooseNode(mm)]=tail ;
        MyWordTreeNode temp=null;
        for (char cc:s.toCharArray()){
            if (tail.k != '\u0000') {
                temp = new MyWordTreeNode();
                tail.left[0] = temp;
                tail = temp;
            }
            tail.k=cc;
        }
        return tail;
    }
}
