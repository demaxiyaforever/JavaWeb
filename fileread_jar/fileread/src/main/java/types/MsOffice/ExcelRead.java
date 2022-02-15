package types.MsOffice;


import Utils.IOutil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class ExcelRead {


    private static String text=" ";

    /**
     * 读取excel和excels，et
     */
    public void getExcelResult(String filename,String outname) {
        BufferedInputStream bis = IOutil.getIn(filename);
        BufferedOutputStream bos =IOutil.getOut(outname);
        try {
            HSSFWorkbook HssfWorkbook = new HSSFWorkbook(bis);
            System.out.println("HssfWorkbook对象：" + HssfWorkbook);
            //读取第一个工作表
            int nums = HssfWorkbook.getNumberOfSheets();
            for(int i=0;i<nums;i++){
                HSSFSheet sheet = HssfWorkbook.getSheetAt(i);
                System.out.println("sheet对象：" + sheet);
                //获取最后一行的num，即总行数。此处从0开始计数
                int maxRow = sheet.getLastRowNum();
                System.out.println("总行数为：" + maxRow);
                for (int row = 0; row <= maxRow; row++) {
                    //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                    int maxRol = sheet.getRow(row).getLastCellNum();
                    System.out.println("--------第" + row + "行的数据如下--------");
                    for (int rol = 0; rol < maxRol; rol++){
                        System.out.print(sheet.getRow(row).getCell(rol) + "  ");
                        HSSFCell cell = sheet.getRow(row).getCell(rol);
                        if(cell!=null){
                            System.out.println(cell.getCellTypeEnum());
                            cell.setCellType(CellType.STRING);
                            text = cell.getStringCellValue();
                            if(!text.equals("")){
                                text+="```";
                                bos.write(text.getBytes());
                                bos.flush();
                            }
//                            switch (cell.getCellTypeEnum()){
//                                case _NONE:
//                                    break;
//                                case NUMERIC:
//                                    bos.write((int) cell.getNumericCellValue());
//                                    break;
//                                case STRING:
//                                    String text = cell.getStringCellValue();
//                                    bos.write(text.getBytes());
//                                case FORMULA:
//                                    bos.write(Integer.parseInt(cell.getCellFormula()));
//                                    break;
//                                case BOOLEAN:
////                                    bos.write(((boolean) cell.getBooleanCellValue()));
//                                    break;
//                                case ERROR:
//                                    bos.write(cell.getErrorCellValue());
//                                    break;
//                            }
                        }
                    }
                    text="***";
                    bos.write(text.getBytes());
                    bos.flush();
                }
            }
            HssfWorkbook.close();
            bos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void getExcelXlsxResult(String filename,String outname){
        BufferedInputStream bis = IOutil.getIn(filename);
        BufferedOutputStream bos =IOutil.getOut(outname);
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(bis);
            System.out.println("xssfWorkbook对象：" + xssfWorkbook);
            //读取工作表
            for(int i=0;i<xssfWorkbook.getNumberOfSheets();i++){
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                System.out.println("sheet对象：" + sheet);
                //获取最后一行的num，即总行数。此处从0开始计数
                int maxRow = sheet.getLastRowNum();
                System.out.println("总行数为：" + maxRow);
                for (int row = 0; row <= maxRow; row++) {
                    //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                    int maxRol = sheet.getRow(row).getLastCellNum();
                    System.out.println("--------第" + row + "行的数据如下--------");
                    for (int rol = 0; rol < maxRol; rol++){
                        System.out.print(sheet.getRow(row).getCell(rol) + "  ");
                        XSSFCell cell = sheet.getRow(row).getCell(rol);
                        if(cell!=null){
                            System.out.println(cell.getCellTypeEnum());
                            cell.setCellType(CellType.STRING);
                            text = cell.getStringCellValue();
                            if(!text.equals("")){
                                text+="```";
                                bos.write(text.getBytes());
                                bos.flush();
                            }
//                            switch (cell.getCellTypeEnum()){
//                                case _NONE:
//                                    break;
//                                case NUMERIC:
//                                    bos.write((int) cell.getNumericCellValue());
//                                    break;
//                                case STRING:
//                                    bos.write(cell.getStringCellValue().getBytes());
//                                case FORMULA:
//                                    bos.write(Integer.parseInt(cell.getCellFormula()));
//                                    break;
//                                case BOOLEAN:
////                                    bos.write(((boolean) cell.getBooleanCellValue()));
//                                    break;
//                                case ERROR:
//                                    bos.write(cell.getErrorCellValue());
//                                    break;
//                            }
                        }
                    }
                    text="***";
                    bos.write(text.getBytes());
                    bos.flush();
                }
            }
            xssfWorkbook.close();
            bos.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
