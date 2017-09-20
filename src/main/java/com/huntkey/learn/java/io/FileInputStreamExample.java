package com.huntkey.learn.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by lulx on 2017/9/18 0018 上午 10:49
 */
public class FileInputStreamExample {
    public static void main(String[] args) {
        fileCount();
    }

    public static void fileCount(){
        int count = 0;
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream("D:/test/java/io/test.txt");
            while (inputStream.read()!=-1){
                count++;
            }
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
