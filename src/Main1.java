import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main1 {
    public static void main(String[] args)   {
        String host = "127.0.0.1";
        int port = 8088;

        try (Socket clientSocet= new Socket(host,port);
             PrintWriter out = new PrintWriter(clientSocet.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocet.getInputStream()))){

            out.println("Dmitrii");

            String resp=in.readLine();
            System.out.println(resp);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}


