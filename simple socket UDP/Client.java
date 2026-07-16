import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[])throws Exception
    {
        DatagramSocket ds=new DatagramSocket();
        System.out.println("Client is ready!");

        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter the message : ");
        String msg=sc.nextLine();

        byte[]send=msg.getBytes();

        DatagramPacket dp=new DatagramPacket(send,send.length,InetAddress.getByName("localhost"),5000);

        ds.send(dp);
        ds.close();

    }
}