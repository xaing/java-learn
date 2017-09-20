package com.huntkey.learn.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by lulx on 2017/9/18 0018 上午 11:10
 */
public class FileOutputStreamExample {
    public static void main(String[] args) {
        fileCopy();
    }

    public static void fileCopy(){
        byte[] buffer = new byte[512];
        int numberRead = 0;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try{
            inputStream = new FileInputStream("D:/test/java/io/test.txt");
            outputStream = new FileOutputStream("D:/test/java/io/test2.txt");
            while ((numberRead=inputStream.read(buffer))!=-1){
                outputStream.write(buffer, 0, numberRead);
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
