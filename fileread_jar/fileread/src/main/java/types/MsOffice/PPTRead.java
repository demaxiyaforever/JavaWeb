package types.MsOffice;

import java.io.*;

import Utils.IOutil;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTable;
import org.apache.poi.hslf.usermodel.HSLFTableCell;
import org.apache.poi.hslf.usermodel.HSLFTextShape;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTextShape;


/**
 * ppt和pptx，dps的处理，按页读取.
 */


import java.util.List;


public class PPTRead {


    private static String text="";

    public void getPPTResult(String filename, String outname) {
        try {
            int flag =1;
            BufferedInputStream bis = IOutil.getIn(filename);
            SlideShow slideShow = null;
            if(filename.endsWith(".ppt")||filename.endsWith(".dps")){
                flag=1;
                slideShow = new HSLFSlideShow(bis);//ppt
            }else if(filename.endsWith(".pptx")){
                flag=2;
                slideShow = new XMLSlideShow(bis);//pptx
            }
            if (slideShow != null) {
                BufferedOutputStream bos = IOutil.getOut(outname);
                if(flag==1){
                    getPPTText(slideShow,bos);
                }else if(flag==2){
                    getPPTXText(slideShow,bos);
                }
                slideShow.close();
                bos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getPPTText(SlideShow slideShow,BufferedOutputStream bos)throws Exception{
        List<Slide> slides = slideShow.getSlides();//后去全部的ppt
        for (Slide slide : slides) {
            List shapes = slide.getShapes();
            if (shapes != null) {
                for (int i = 0; i < shapes.size(); i++) {
                    Shape shape = (Shape) shapes.get(i);
                    if (shape instanceof HSLFTextShape) {// 文本框
                        text+= ((HSLFTextShape) shape).getText();
                        bos.write(text.getBytes());
                        bos.flush();
                        text="";
                    }
                    if (shape instanceof HSLFTable) {// 表格
                        int rowSize = ((HSLFTable) shape).getNumberOfRows();
                        int columnSize = ((HSLFTable) shape).getNumberOfColumns();
                        for (int rowNum = 0; rowNum < rowSize; rowNum++) {
                            for (int columnNum = 0; columnNum < columnSize; columnNum++) {
                                HSLFTableCell cell = ((HSLFTable) shape).getCell(rowNum, columnNum);
                                if (cell != null) {
                                    text+= cell.getText();
                                    bos.write(text.getBytes());
                                    bos.flush();
                                    text="";
                                }
                            }
                        }
                    }
/**
 * 图片
  */
//                    List pictures = slideShow.getPictureData();
//                    for (int j = 0; j < pictures.size(); j++) {
//                        PictureData picture = (PictureData) pictures.get(i);
//                        byte[] data = picture.getData();
//                        FileOutputStream out = new FileOutputStream("D:\\temp\\temp\\" + UUID.randomUUID() + ".jpg");
//                        out.write(data);
//                        out.close();
//                    }
                }

            }
            text+="```";
            bos.write(text.getBytes());
            bos.flush();
            text="";
        }
    }

    public void getPPTXText(SlideShow slideShow,BufferedOutputStream bos)throws Exception{
        List<Slide> slides = slideShow.getSlides();//后去全部的pptx
        for (Slide slide : slides) {
            List shapes = slide.getShapes();
            if (shapes != null) {
                for (int i = 0; i < shapes.size(); i++) {
                    Shape shape = (Shape) shapes.get(i);
                    if (shape instanceof XSLFTextShape) {// 文本框
                        text+= ((XSLFTextShape) shape).getText();
                        bos.write(text.getBytes());
                        bos.flush();
                        text="";
                    }
                    if (shape instanceof XSLFTable) {// 表格
                        int rowSize = ((XSLFTable) shape).getNumberOfRows();
                        int columnSize = ((XSLFTable) shape).getNumberOfColumns();
                        for (int rowNum = 0; rowNum < rowSize; rowNum++) {
                            for (int columnNum = 0; columnNum < columnSize; columnNum++) {
                                XSLFTableCell cell = ((XSLFTable) shape).getCell(rowNum, columnNum);
                                if (cell != null) {
                                    text+= cell.getText();
                                    bos.write(text.getBytes());
                                    bos.flush();
                                    text="";
                                }
                            }
                        }
                    }
/**
 * 图片
 */
//                    List pictures = slideShow.getPictureData();
//                    for (int j = 0; j < pictures.size(); j++) {
//                        PictureData picture = (PictureData) pictures.get(i);
//                        byte[] data = picture.getData();
//                        FileOutputStream out = new FileOutputStream("D:\\temp\\temp\\" + UUID.randomUUID() + ".jpg");
//                        out.write(data);
//                        out.close();
//                    }
                }

            }
            text+="```";
            bos.write(text.getBytes());
            bos.flush();
            text="";
        }
    }
}
