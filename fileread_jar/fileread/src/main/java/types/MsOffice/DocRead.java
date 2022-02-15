package types.MsOffice;

import Utils.IOutil;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.util.List;

/**
 * 解析微软doc和docx，wps
 */
public class DocRead {

    private static String result = "";

    public  void getDocResult(String filename,String outename) {

        try {
            BufferedInputStream bis = IOutil.getIn(filename);
            BufferedOutputStream bos = IOutil.getOut(outename);
            WordExtractor wordExtractor = new WordExtractor(bis);
            String[] paragraphs = wordExtractor.getParagraphText();
//            XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(filename));
//            int pages = document.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
//            result = Integer.toString(pages);
            for(int i=0;i< paragraphs.length;i++){
                bos.write(paragraphs[i].getBytes());
                bos.flush();
            }
            int pages=wordExtractor.getSummaryInformation().getPageCount();
            result = Integer.toString(pages);
            bos.write(result.getBytes());
            bos.flush();
            wordExtractor.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDocxResult(String filename,String outname){
        try {
            BufferedInputStream bis = IOutil.getIn(filename);
            BufferedOutputStream bos = IOutil.getOut(outname);
            XWPFDocument xwpfDocument = new XWPFDocument(bis);
            List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
            for(XWPFParagraph paragraph:paragraphs){
                result=paragraph.getParagraphText();
                result+="```";
                bos.write(result.getBytes());
                bos.flush();
            }
            xwpfDocument.close();
            bos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
