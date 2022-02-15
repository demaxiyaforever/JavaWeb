//package types;
//
//import java.io.*;
//import java.util.*;
//
//import org.dom4j.*;
//import org.dom4j.io.*;
//
//public class XmlRead {
//    public static void getXmlResult(String filename) {
//        try {
//            File f = new File(filename);
//            SAXReader reader = new SAXReader();
//            Document doc = reader.read(f);
//            Element root = doc.getRootElement();
//            Element foo;
//            for (Iterator i = root.elementIterator("VALUE"); i.hasNext(); ) {
//                foo = (Element) i.next();
//                System.out.println(foo.getText());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

package types.OtFile;

import Utils.IOutil;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.*;
import java.util.List;

/**
 * JDom解析xml
 */
public class XmlRead {

    private static String str=" ";

    public void getXmlResult(String filename,String outname) throws Exception{
        //1.创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        //2.创建输入流和写入的txt

        BufferedInputStream bis = IOutil.getIn(filename);//创建输出流,创建缓冲区
        BufferedOutputStream bos = IOutil.getOut(outname);
        //3.将输入流加载到build中
        Document document = saxBuilder.build(bis);
        //4.获取根节点
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        //5.获取子节点
        List<Element> children = rootElement.getChildren();
        for (Element child : children) {
            List<Element> childrenList = child.getChildren();
            for (Element o : childrenList) {
                str = o.getName();
                System.out.println(str);
                str+="\r\n";
                bos.write(str.getBytes());
                str = o.getValue();
                System.out.println(str);
                str+="\r\n";
                bos.write(str.getBytes());//写入缓冲区
                bos.flush();//刷新缓冲区
//                System.out.println("节点名:" + o.getName() + "节点值:" + o.getValue());
            }
        }
        bis.close();
        bos.close();
    }
}
