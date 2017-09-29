package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer {

    private static int PORT = 7777;
    private static String IP = "localhost";
    private static ServerSocket serverSocket;
    private static Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            PORT = Integer.parseInt(args[0]);
            IP = args[1];
        }

        serverSocket = new ServerSocket(); // Important to bind socket
        serverSocket.bind(new InetSocketAddress(IP, PORT));
        System.out.println("Wating for a client...");

        while (true) {
            Socket socket = serverSocket.accept(); // Blocking call!
            System.out.println("New client found!");
            handleClient(socket);
        }

    }

    public static void handleClient(Socket s) throws IOException {

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true); //must always leave autoflush on true! False by default.
        

        pw.println("Recieved a request for time:");
        pw.println(calendar.getTime());
        System.out.println("Received a request time:");
        System.out.println(calendar.getTime());
        s.close();
    }

}
