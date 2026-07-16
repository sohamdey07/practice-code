import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server{
    public static void main(String args[]) throws Exception
    {
        ServerSocket ss=new ServerSocket(5000);
        System.out.println("Server is waiting...");

        Socket s=ss.accept();
        System.out.println("Client is connected!");
        System.out.println();


        DataInputStream in=new DataInputStream(s.getInputStream());
        DataOutputStream out=new DataOutputStream(s.getOutputStream());

        // Scanner sc=new Scanner(System.in);
        String msg=in.readUTF();

        System.out.println("Client : "+msg);

        out.writeUTF(msg);
        ss.close();

    }
}