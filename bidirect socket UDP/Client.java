import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[])throws Exception
    {
        DatagramSocket ds=new DatagramSocket();
        Scanner sc=new Scanner(System.in);
        System.out.println("Client is ready!");
        while(true)
        {
            System.out.print("Client : ");
            String sendMsg=sc.nextLine();

            byte[]send=sendMsg.getBytes();
            DatagramPacket dp=new DatagramPacket(send,send.length,InetAddress.getByName("localhost"),5000);
            ds.send(dp);

            byte[] receive=new byte[1024];
            DatagramPacket mp=new DatagramPacket(receive,receive.length);
            ds.receive(mp);

            String msg=new String(mp.getData(),0,mp.getLength());

            System.out.println("Server : "+msg);
            System.out.println();
        }
    }
}