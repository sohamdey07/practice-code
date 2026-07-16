import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost",5000);
        System.out.println("Client is ready!");

        DataInputStream in=new DataInputStream(s.getInputStream());
        DataOutputStream out=new DataOutputStream(s.getOutputStream());

        while(true){
            Scanner sc=new Scanner(System.in);
            out.writeUTF(sc.nextLine());

            System.out.println("Server: "+in.readUTF());
        }
        // s.close();
    }
}