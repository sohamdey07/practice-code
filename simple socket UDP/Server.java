import java.net.*;

public class Server{
    public static void main(String args[])throws Exception{
        DatagramSocket ds=new DatagramSocket(5000);

        byte receive[]=new byte[1024];
        DatagramPacket dp=new DatagramPacket(receive,receive.length);

        System.out.println("Server is waiting...");
        ds.receive(dp);

        String msg=new String(dp.getData(),0,dp.getLength());
        System.out.println("Message from Client : "+msg);

        ds.close();
    }
}