import java.io.*;
import java.net.*;

public class Server{
    public static void main(String args[])throws Exception{
        ServerSocket ss=new ServerSocket(5000);
        System.out.println("Server is waiting ...");

        Socket s=ss.accept();
        System.out.println("Client is connected!");

        DataInputStream in=new DataInputStream(s.getInputStream());
        System.out.println("Message from client: "+in.readUTF());

        ss.close();
    }
}