package Utils;

import types.MsOffice.DocRead;
import types.MsOffice.ExcelRead;
import types.MsOffice.PPTRead;
import types.OtFile.HtmlRead;
import types.OtFile.PdfRead;
import types.OtFile.XmlRead;

public class SlUtil {
    public static void getResult(String filename,String code,String outname){
        PPTRead pptRead = new PPTRead();
        ExcelRead excelRead = new ExcelRead();
        PdfRead pdfRead = new PdfRead();
        DocRead docRead = new DocRead();
        try{
            switch(code){
                case "0x2":
                    HtmlRead htmlRead = new HtmlRead();
                    htmlRead.getHtmlResult(filename,outname);
                    break;//html
                case "0x4":
                    XmlRead xmlRead = new XmlRead();
                    xmlRead.getXmlResult(filename,outname);
                    break;//xml
                case "0x8":
                    docRead.getDocxResult(filename,outname);
//                pptRead.getPPTResult("C:\\Users\\james1148160216\\Desktop\\7.dps","C:\\Users\\james1148160216\\Desktop\\6.txt");
//                    pdfRead.getPDFResult("D:\\23ky\\计算机组成谭志虎\\计算机组成新教案\\2107de1db100e871b0d5-1.pdf","C:\\Users\\james1148160216\\Desktop\\6.txt");
                    break;//doc
                case "0x10":
                case "0x80":
                    excelRead.getExcelResult(filename,outname);
                    //                    excelRead.getExcelXlsxResult("D:\\互联网+\\截至6月8日9：20am报名成功的互联网+参赛项目汇总表（627项）.xlsx","C:\\Users\\james1148160216\\Desktop\\6.txt");
                    break;//xls和et
                case "0x20":
                case "0x100":
                    pptRead.getPPTResult(filename,outname);
                    break;//ppt
                case "0x40":
                    docRead.getDocResult(filename,outname);
                    break;//wps
                case "0x200":
                    break;//odt
                case "0x400":
                    break;//ods
                case "0x800":
                    break;//odp
                case "0x1000":
                    break;//jpg
                case "0x2000":
                    break;//bmp
                case "0x4000":
                    break;//png
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
