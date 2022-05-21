package day10.src.com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * 实现TCP的网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author shkstart
 * @create 2019 下午 3:53
 */
public class TCPTest2 {

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        //1创建socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.创建输出流
        OutputStream os  = socket.getOutputStream();
        //3.文件输入流
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));
        //4.读入数据到输出流中
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1){
            os.write(buffer, 0,len);
        }
        //关闭流
        fis.close();
        os.close();
        socket.close();

    }

    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void server() throws IOException {
        //创建服务器端的接受端口
        ServerSocket ss = new ServerSocket(9090);
        //服务器端开始接受数据
        Socket socket = ss.accept();
        //从socket中读入输入流
        InputStream is = socket.getInputStream();

        //创建文件输出流
        FileOutputStream fos = new FileOutputStream(new File("beauty1.jpg"));
        //将输入流中得到的数据  弄到文件输出流中
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //关闭流
        fos.close();
        is.close();
        socket.close();
        ss.close();

    }
}
