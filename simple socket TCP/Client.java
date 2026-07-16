import java.io.*;
import java.net.*;

public class Client{
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost",5000);
        System.out.println("Client is ready!");

        DataOutputStream out=new DataOutputStream(s.getOutputStream());
        out.writeUTF("Hello World!");

        s.close();
    }
}