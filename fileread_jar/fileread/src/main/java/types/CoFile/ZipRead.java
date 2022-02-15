package types.CoFile;

import Utils.IOutil;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 解析zip
 */
public class ZipRead {
    public void getZipResult(String filename, String outname) throws Exception {
        ZipInputStream zin = new ZipInputStream(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(new InputStreamReader(zin, "utf-8"));
        ZipEntry zipEntry;
        while ((zipEntry=zin.getNextEntry())!=null) {
            //如果是目录，不处理
            if (zipEntry.isDirectory()){
                System.err.println("当前路径为目录："+zipEntry.getName());
            }
            //获得cvs名字
            String fileName = zipEntry.getName();
            //检测文件是否存在
            if (fileName != null && fileName.indexOf(".") != -1) {
                System.out.println("---------------------开始解析文件："+fileName+"-----------------------------");
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        //关闭流
        br.close();
        zin.close();
    }
}
