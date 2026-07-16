import java.net.*;
import java.util.Scanner;

public class Server{
    public static void main(String args[])throws Exception
    {
        DatagramSocket ds=new DatagramSocket(5000);
        Scanner sc=new Scanner(System.in);
        System.out.println("Server is waiting...");
        byte[]receive=new byte[1024];

        while(true)
        {
            DatagramPacket dp=new DatagramPacket(receive,receive.length);
            ds.receive(dp);

            String msg=new String(dp.getData(),0,dp.getLength());
            System.out.println("\nClient : "+msg);

            System.out.print("Server : ");
            String sendMsg=sc.nextLine();

            byte[]send=sendMsg.getBytes();

            DatagramPacket mp=new DatagramPacket(send,send.length,dp.getAddress(),dp.getPort());
            ds.send(mp);
        }
    }
}