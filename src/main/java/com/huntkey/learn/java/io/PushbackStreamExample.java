package com.huntkey.learn.java.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by lulx on 2017/9/18 0018 下午 1:50
 */
public class PushbackStreamExample {
    public static void main(String[] args) throws IOException {
        pushbackStream();
    }
    public static void pushbackStream() throws IOException {
        String str = "hello,pushbackStream";
        PushbackInputStream pushbackInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
        int tmp = 0;
        while ((tmp=pushbackInputStream.read())!=-1){
            //System.out.println(tmp);
            if(tmp == 44){

                pushbackInputStream.unread(tmp); //回到temp的位置
                tmp = pushbackInputStream.read(); //接着读取字节
                System.out.print("(回退" + (char) tmp + ") "); // 输出回退的字符
            }else{
                System.out.print((char) tmp); // 否则输出字符
            }
        }
    }
}
