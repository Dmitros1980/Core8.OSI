import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8088;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocet =serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocet.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocet.getInputStream()));
                ) {
                    System.out.printf("New connections accepted.Port: %d%n", clientSocet.getPort());

                    final String name = in.readLine();
                    out.println(String.format("Hi %s ,your port is %d",name,clientSocet.getPort()));
                }
            }
        }
    }
}
