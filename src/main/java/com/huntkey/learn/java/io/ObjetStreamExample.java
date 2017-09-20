package com.huntkey.learn.java.io;

import java.io.*;

/**
 * Created by lulx on 2017/9/18 0018 上午 11:30
 */
public class ObjetStreamExample {
    public static void main(String[] args) {
        objectStream();
    }

    public static void objectStream(){
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream("D:/test/java/io/student.txt"));
            outputStream.writeObject(new Student("A1",1));
            outputStream.writeObject(new Student("A2",2));
            outputStream.writeObject(new Student("A3",3));
            inputStream = new ObjectInputStream(new FileInputStream("D:/test/java/io/student.txt"));
            for (int i = 0; i < 3; i++) {
                System.out.println(inputStream.readObject());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Student implements Serializable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, int age) {
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
}