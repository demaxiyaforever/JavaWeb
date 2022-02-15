package types.OtFile;

import Utils.IOutil;
import jakarta.mail.Address;
import jakarta.mail.Multipart;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.Properties;

public class EmlRead {

    private static String str = "";
    private static String bt="" ;

    public void getEmlResult(String filename, String outname) {
        try {
            BufferedInputStream bis = IOutil.getIn(filename);
            BufferedOutputStream bos = IOutil.getOut(outname);
            Properties props = System.getProperties();
            Session mails = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(mails, bis);
            ;//解析message就行，接下来弄明白message
            str = message.getSubject() + "\r\n";
            bos.write(str.getBytes());
            parseEml(message, bos);
            bos.flush();
            bis.close();
            bos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***
     * 解析开头的内容，标题等
     * @param msg
     * @throws Exception
     */
    private void parseEml(MimeMessage msg, BufferedOutputStream bos) throws Exception {
        // 发件人信息
        Address[] froms = msg.getFrom();
        if (froms != null) {
            // System.out.println("发件人信息:" + froms[0]);
            InternetAddress addr = new InternetAddress();
            for(int i=0;i< froms.length;i++){
                addr = (InternetAddress) froms[i];
                str = addr.toUnicodeString();
                System.out.println(str);
                bos.write(str.getBytes());
                bos.flush();
            }
        }
        System.out.println("邮件主题:" + msg.getSubject());
        // getContent() 是获取包裹内容, Part相当于外包装
        Object o = msg.getContent();
        if (o instanceof Multipart) {
            Multipart multipart = (Multipart) o;
            reMultipart(multipart);
            bos.write(bt.getBytes());
            bos.flush();
        } else if (o instanceof Part) {
            Part part = (Part) o;
            rePart(part);
            System.out.println(bt);
            bos.write(bt.getBytes());
            bos.flush();
        } else {
            System.out.println("类型" + msg.getContentType());
            System.out.println("内容" + msg.getContent());
        }
    }


    /**
     * @param part 解析内容
     * @throws Exception
     */
    private void rePart(Part part) throws Exception {

        if (part.getDisposition() != null) {
//处理附件
//            String strFileNmae = part.getFileName();
//            if(!StringUtils.isEmpty(strFileNmae))
//            {	// MimeUtility.decodeText解决附件名乱码问题
//                strFileNmae= MimeUtility.decodeText(strFileNmae);
//                System.out.println("发现附件: "+ strFileNmae);
//
//                InputStream in = part.getInputStream();// 打开附件的输入流
//                // 读取附件字节并存储到文件中
//                java.io.FileOutputStream out = new FileOutputStream(strFileNmae);
//                int data;
//                while ((data = in.read()) != -1) {
//                    out.write(data);
//                }
//                in.close();
//                out.close();
//
//            }
//
//            System.out.println("内容类型: "+ MimeUtility.decodeText(part.getContentType()));
//            System.out.println("附件内容:" + part.getContent());


        } else {
            if (part.getContentType().startsWith("text/plain")) {
//                bt.append(part.getContent());
//                str=bt.toString();
//                System.out.println(part.getContent());
                bt=part.getContent().toString();
//                System.out.println(bt);
            } else {
                // System.out.println("HTML内容：" + part.getContent());
            }
        }
    }

    /**
     * @param multipart // 解析包裹（含所有邮件内容(包裹+正文+附件)）
     * @throws Exception
     */
    private void reMultipart(Multipart multipart) throws Exception {
        // System.out.println("邮件共有" + multipart.getCount() + "部分组成");
        // 依次处理各个部分
        for (int j = 0, n = multipart.getCount(); j < n; j++) {
            // System.out.println("处理第" + j + "部分");
            Part part = multipart.getBodyPart(j);// 解包, 取出 MultiPart的各个部分,
            // 每部分可能是邮件内容,
            // 也可能是另一个小包裹(MultipPart)
            // 判断此包裹内容是不是一个小包裹, 一般这一部分是 正文 Content-Type: multipart/alternative
            if (part.getContent() instanceof Multipart) {
                Multipart p = (Multipart) part.getContent();// 转成小包裹
                // 递归迭代
                reMultipart(p);
            } else {
                rePart(part);
            }
        }
    }


    public static String getMailContent(Part part) throws Exception {
        String contenttype = part.getContentType();
        int nameindex = contenttype.indexOf("name");
        boolean conname = false;
        if (nameindex != -1) {
            conname = true;
        }
        StringBuilder bodytext = new StringBuilder();
        if (part.isMimeType("text/plain") && !conname) {
            bodytext.append((String) part.getContent());
        } else if (part.isMimeType("text/html") && !conname) {
            bodytext.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                getMailContent(multipart.getBodyPart(i));
            }
        } else if (part.isMimeType("message/rfc822")) {
            getMailContent((Part) part.getContent());
        } else {
        }
        return bodytext.toString();
    }

}
