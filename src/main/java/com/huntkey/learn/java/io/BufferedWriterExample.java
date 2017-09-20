package com.huntkey.learn.java.io;

import java.io.*;

/**
 * Created by lulx on 2017/9/18 0018 下午 2:51
 */
public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            String[] strs = {"D:/test/java/io/test2.txt","D:/test/java/io/test3.txt","D:/test/java/io/test4.txt"};
            concennateFile(strs);
        } catch (Exception e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private static void concennateFile(String... fileName) throws IOException {
        String str;
        //构建对该文件您的输入流
        BufferedWriter writer=new BufferedWriter(new FileWriter("D:/test/java/io/test5.txt"));
        for(String name: fileName){
            BufferedReader reader=new BufferedReader(new FileReader(name));
            while ((str=reader.readLine())!=null) {
                writer.write(str);
                writer.newLine();
            }
        }
    }
}
