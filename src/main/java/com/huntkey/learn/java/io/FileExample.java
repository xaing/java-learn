package com.huntkey.learn.java.io;

import java.io.File;

/**
 * Created by lulx on 2017/9/18 0018 上午 10:29
 */
public class FileExample {
    public static void main(String[] args) {
        createFile();
    }

    public static void createFile(){
        File file = new File("D:/test/java/io/test.txt");
        File f = new File("D:/test/java/io/");
        try {
            f.mkdirs();
            file.createNewFile();
            //System.out.println("分区大小： "+file.getTotalSpace()/(1024*1024*1024)+"G");
            System.out.println(file.getName());
            System.out.println(file.getParent());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
