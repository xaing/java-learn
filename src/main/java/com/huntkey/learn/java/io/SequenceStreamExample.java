package com.huntkey.learn.java.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by lulx on 2017/9/18 0018 下午 2:28
 */
public class SequenceStreamExample {
    public static void main(String[] args) {
        sequenceStream();
    }

    public static void sequenceStream(){
        SequenceInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            Vector<InputStream> streams = new Vector<InputStream>();
            streams.add(new FileInputStream("D:/test/java/io/test.txt"));
            streams.add(new FileInputStream("D:/test/java/io/test2.txt"));
            Enumeration<InputStream> e = streams.elements();
            inputStream = new SequenceInputStream(e);
            outputStream = new BufferedOutputStream(new FileOutputStream("D:/test/java/io/test3.txt"));
            // 读写数据
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
                outputStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
