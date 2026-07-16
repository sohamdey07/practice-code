import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost",5000);
        System.out.println("Client is ready!");

        DataOutputStream out=new DataOutputStream(s.getOutputStream());
        System.out.print("Client :");

        Scanner sc=new Scanner(System.in);
        out.writeUTF(sc.nextLine());

        s.close();
    }
}