import java.net.*;
import java.io.*;

class ClientThread extends Thread{
    Socket s;
    ClientThread(Socket s)
    {
        this.s=s;
    }

    public void run()
    {
        try{
            DataInputStream in=new DataInputStream(s.getInputStream());
            System.out.println("Client : "+in.readUTF());
            s.close();
        }
        catch(Exception e)
        {}
    }
}
public class Server{
    public static void main(String args[])throws Exception{
        ServerSocket ss=new ServerSocket(5000);
        System.out.println("Server is waiting...");

        while(true)
        {
            Socket s=ss.accept();
            System.out.println("\nClient is connected!");
            new ClientThread(s).start();
        }
    }
}