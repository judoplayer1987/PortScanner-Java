/**
 * This is a basic port scanner that operates on 1 thread. It is slow because of that, but adding more threads will
 * accelerate scanning.
 */
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {
    public static void main(String[] args) throws Exception {
        //Capturing target system
        Scanner reader = new Scanner(System.in);
        System.out.println("What IP do you want scanned?: ");

        String host = reader.next();
        InetAddress inetAddress = InetAddress.getByName(host);

        //Initializing log of target system
        FileOutputStream out = null;
        out = new FileOutputStream("ExposedPorts.txt");

        String hostName = inetAddress.getHostName();
        //Scanning target
        for (int port = 0; port <= 65535; port++) {
            try {
                Socket socket = new Socket(hostName, port);
                String text = hostName + " is listening on port " + port + "\n";
                //Logging target's open ports
                System.out.println(text);
                out.write(text.getBytes());
                socket.close();
            } catch (IOException e) {
                String s = hostName + " is not listening on port " + port;
                System.out.println(s);
            }
        }
        //For loop to cycle thru open ports and compare against portlist.txt goes here
            //Read ExposedPorts.txt line by line
            //Cast each line as a list
            //use [-1] to catch the port
            //Save port to variable
            //Search thru Portlist.txt for saved variable
            //Output in form: $variable is $service and connects by TCP/UDP

    }
}
