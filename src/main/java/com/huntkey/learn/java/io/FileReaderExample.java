package com.huntkey.learn.java.io;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lulx on 2017/9/18 0018 下午 2:44
 */
public class FileReaderExample {
    public static void main(String[] args) {
        char[] buffer = new char[512];
        int numberRead = 0;
        FileReader reader = null;
        PrintWriter writer = null;
        try{
            reader = new FileReader("D:/test/java/io/test3.txt");
            //writer=new PrintWriter(System.out);  //PrintWriter可以输出字符到文件，也可以输出到控制台
            writer = new PrintWriter(new FileOutputStream("D:/test/java/io/test4.txt"));
            while ((numberRead=reader.read(buffer))!=-1) {
                writer.write(buffer, 0, numberRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }
}
