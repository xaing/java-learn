package com.huntkey.learn.java.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by lulx on 2017/9/18 0018 上午 11:44
 */
public class DataStreamExample {
    public static void main(String[] args) {
        dataStream();
    }
    public static void dataStream(){
        Member[] members = {new Member("A1",1),
                new Member("A2",2),
                new Member("A4",4),
                new Member("A3",3)};

        Member[] members1 = new Member[4];
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("D:/test/java/io/member.txt"));
            for(Member member : members){
                dataOutputStream.writeUTF(member.getName());
                dataOutputStream.writeInt(member.getAge());
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:/test/java/io/member.txt"));
            for(int i=0;i<members.length;i++) {
                String name =dataInputStream.readUTF();
                int score =dataInputStream.readInt();
                members1[i] = new Member(name,score);
            }
            dataInputStream.close();
            for(Member member : members1){
                System.out.println(member.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Member{
    private String name;
    private int age;

    public Member() {
    }

    public Member(String name, int age) {
        this.name = name;

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
