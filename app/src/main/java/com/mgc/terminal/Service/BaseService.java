package com.mgc.terminal.Service;



import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import com.mgc.terminal.bean.SingletData;
public class BaseService {
    public Socket getSocket() throws Exception{
        System.out.println(SingletData.getInstance().getIp());
        System.out.println(SingletData.getInstance().getPort());
        Socket socket=new Socket(SingletData.getInstance().getIp(),SingletData.getInstance().getPort());
        return socket;
    }
    public BufferedWriter getBw(Socket s) throws Exception{
        OutputStream os=s.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
        return bw;
    }
}
