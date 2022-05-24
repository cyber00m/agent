package Agent.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5400);
        Socket backend = new Socket();
        Socket fg = server.accept();
        System.out.println("FG connected!");
        Socket clientToBackend= new Socket("localhost",1234);
        Client client = new Client(clientToBackend);
        BufferedReader in = new BufferedReader(new InputStreamReader(fg.getInputStream()));
        String line;
        String fileName="file.csv";///
        FileWriter outToFile = new FileWriter(new File(fileName));
        while((line = in.readLine() )!= null ) {
            System.out.println(line);
            client.sendMsg(line+"\n");
            outToFile.write(line+"\n");
            outToFile.flush();
        }

        client.sendMsg("done");
        in.close();
        fg.close();
        client.close(clientToBackend);
        System.out.println("done");

    }
}

