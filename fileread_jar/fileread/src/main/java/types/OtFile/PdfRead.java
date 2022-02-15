package types.OtFile;

import Utils.IOutil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * pdf，ofd阅读pdfbox
 */

public class PdfRead {
    private static String text = " ";
    public void getPDFResult(String filename,String outname){
        BufferedInputStream bis = IOutil.getIn(filename);
        BufferedOutputStream bos = IOutil.getOut(outname);
        PDDocument document = null;
        try {
            document=PDDocument.load(bis);
            PDFTextStripper stripper = new PDFTextStripper();//使用pdftextstripper来提取文本
            stripper.setSortByPosition(true);//设置是否排序
            int num=document.getNumberOfPages();
            //每一页分开读
            for(int i=1;i<=num;i++){
                stripper.setStartPage(i);
                stripper.setEndPage(i);
                text= stripper.getText(document);
                text+="```";
                bos.write(text.getBytes());
                bos.flush();
                text=" ";
            }
            document.close();
            bos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
