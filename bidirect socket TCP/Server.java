import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server{
    public static void main(String args[])throws Exception{
        ServerSocket ss=new ServerSocket(5000);
        System.out.println("Server is waiting...");

        Socket s=ss.accept();
        System.out.println("CLient is connected!");


        DataInputStream in=new DataInputStream(s.getInputStream());
        DataOutputStream out=new DataOutputStream(s.getOutputStream());

        while(true){

            System.out.println("Client: "+in.readUTF());
            
            Scanner sc=new Scanner(System.in);
            out.writeUTF(sc.nextLine());
        }
        // ss.close();
    }
}