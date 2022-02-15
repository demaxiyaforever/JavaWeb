package types.CoFile;

import Utils.IOutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 解析zip
 */


public class OdtRead {
    public void getOdtResult(String filename,String outname){
        BufferedOutputStream bos = IOutil.getOut(outname);
        try {
            ZipFile zipFile = new ZipFile(filename);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
