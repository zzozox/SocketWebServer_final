package Responser;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 应答报文发送器 接口
 */
abstract public class Responser {
    //资源根目录
    protected static String BASEPATH = "E:\\LaboratoryReport\\ComputerNetwork\\zzx\\SocketWebServer\\resources";

    public static void setBasePath(String path){ BASEPATH=path; }

    public static String getBasePath(){return BASEPATH;}

    protected OutputStream outputStream;

//发送应答
    abstract public boolean send() throws Exception;
    /**
     * 发送仅包含一个状态码的简单应答
     * @param codeAndText 状态码和描述
     * @throws Exception 一切异常
     */
    protected void sendCodeAndText(String codeAndText) throws Exception{
        try(PrintStream writer = new PrintStream(outputStream)) {
            writer.println("HTTP/1.1 " + codeAndText);
            writer.println("Content-Type:text/plain");
            writer.println("Content-Length:" + codeAndText.length());
            writer.println();
            //发送响应体
            writer.print(codeAndText);
            writer.flush();
        }
    }
}
