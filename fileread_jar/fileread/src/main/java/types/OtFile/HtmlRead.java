package types.OtFile;

import java.io.*;

import Utils.IOutil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Jsoup解析html标签时类似于JQuery的一些符号
 *
 * @author chixh
 */
public class HtmlRead {
    private static String str ="";
//    protected List<List<String>> data = new LinkedList<List<String>>();
//
//    /**
//     * 获取value值
//     *
//     * @param e
//     * @return
//     */
//    public static String getValue(Element e) {
//        return e.attr("value");
//    }
//
//    /**
//     * 获取
//     * <tr>
//     * 和
//     * </tr>
//     * 之间的文本
//     *
//     * @param e
//     * @return
//     */
//    public static String getText(Element e) {
//        return e.text();
//    }
//
//    /**
//     * 识别属性id的标签,一般一个html页面id唯一
//     *
//     * @param body
//     * @param id
//     * @return
//     */
//    public static Element getID(String body, String id) {
//        Document doc = Jsoup.parse(body);
//        // 所有#id的标签
//        Elements elements = doc.select("#" + id);
//        // 返回第一个
//        return elements.first();
//    }
//
//    /**
//     * 识别属性class的标签
//     *
//     * @param body //     * @param class
//     * @return
//     */
//    public static Elements getClassTag(String body, String classTag) {
//        Document doc = Jsoup.parse(body);
//        // 所有#id的标签
//        return doc.select("." + classTag);
//    }
//
//    /**
//     * 获取tr标签元素组
//     *
//     * @param e
//     * @return
//     */
//    public static Elements getTR(Element e) {
//        return e.getElementsByTag("tr");
//    }
//
//    /**
//     * 获取td标签元素组
//     *
//     * @param e
//     * @return
//     */
//    public static Elements getTD(Element e) {
//        return e.getElementsByTag("td");
//    }
//    /**
//     * 获取表元组
//     * @param table
//     * @return
//     */
//    /**
//     * 读html文件
//     *
//     * @param fileName
//     * @return
//     */

    /**
     * 将html解析成字符串
     * @param fileName
     * @return
     */
    public String readHtml(String fileName) {
        BufferedInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            fis = IOutil.getIn(fileName);
            byte[] bytes = new byte[1024];
            while (-1 != fis.read(bytes)) {
                sb.append(new String(bytes));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    /**
     * 将html字符串通过jsoup解析成结点
     * @param filename
     * @param outname
     * @throws Exception
     */
    public void getHtmlResult(String filename,String outname)throws Exception{
        Document doc = Jsoup.parse(readHtml(filename));
        Elements nodes = doc.getAllElements();
        BufferedOutputStream bos = IOutil.getOut(outname);
        for(Element node :nodes){
            if (!node.ownText().equals("")){
                str=node.ownText()+"\r\n";
                bos.write(str.getBytes());
                bos.flush();
            }
        }
        bos.close();
    }
}

