import java.net.*;
import java.util.Scanner;

public class EchoClient{
    public static void main(String args[])throws Exception{
        DatagramSocket ds=new DatagramSocket();

        Scanner sc=new Scanner(System.in);
        System.out.println("Client is ready!");

        System.out.print("\nEnter new Message :");
        String msg=sc.nextLine();

        byte[]msgSend=msg.getBytes();

        DatagramPacket dp=new DatagramPacket(msgSend,msgSend.length,InetAddress.getByName("localhost"),5000);
        ds.send(dp);

        byte[]echo=new byte[1024];
        DatagramPacket mp=new DatagramPacket(echo,echo.length,dp.getAddress(),dp.getPort());
        ds.receive(mp);

        String receiveMsg=new String(mp.getData(),0,mp.getLength());
        System.out.println("Echo from Server : "+receiveMsg);
        ds.close();
    }
}