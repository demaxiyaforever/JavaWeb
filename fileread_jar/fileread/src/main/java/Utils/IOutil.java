package Utils;

import java.io.*;

public class IOutil {
    public static BufferedInputStream getIn(String filename){
        FileInputStream fin = null;//输入流
        BufferedInputStream bis = null;//输入缓冲区
        try {
            fin = new FileInputStream(filename);
            bis = new BufferedInputStream(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bis;
    }

    public static BufferedOutputStream getOut(String filename){
        FileOutputStream fin = null;//输出流
        BufferedOutputStream bis = null;//输出缓冲区
        try {
            fin = new FileOutputStream(filename);
            bis = new BufferedOutputStream(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bis;
    }
}
