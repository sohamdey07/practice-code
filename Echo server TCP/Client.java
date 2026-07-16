import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[])throws Exception
    {
        Socket s=new Socket("localhost",5000);
        System.out.println("Client is ready!");

        DataInputStream in=new DataInputStream(s.getInputStream());
        DataOutputStream out=new DataOutputStream(s.getOutputStream());

        System.out.print("Enter new message: ");
        Scanner sc=new Scanner(System.in);
        out.writeUTF(sc.nextLine());

        System.out.println();
        System.out.println("Echo from server : "+in.readUTF());
        s.close();
    }
}