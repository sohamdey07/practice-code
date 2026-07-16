import java.net.*;

public class EchoServer{
    public static void main(String args[])throws Exception{
        DatagramSocket ds=new DatagramSocket(5000);
        byte[]receive=new byte[1024];

        System.out.println("Server is waiting...");
        DatagramPacket dp=new DatagramPacket(receive,receive.length);

        ds.receive(dp);

        String msg=new String(dp.getData(),0,dp.getLength());
        System.out.println("Client : "+msg);

        byte[]reply=msg.getBytes();
        DatagramPacket mp=new DatagramPacket(reply,reply.length,dp.getAddress(),dp.getPort());
        ds.send(mp);
        ds.close();

    }
}