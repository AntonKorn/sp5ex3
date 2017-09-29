package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
  
    Socket socket;
    Scanner scan;
    PrintWriter pw;
    
    public void connect(String ip, int port) throws IOException{
        socket = new Socket(ip,port);
        pw = new PrintWriter(socket.getOutputStream(),true);
    }
    
    
  
    
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.connect("localhost", 7777);
        System.out.println("A client wanted to know the time");
        System.out.println("Done");
    }
    
}
