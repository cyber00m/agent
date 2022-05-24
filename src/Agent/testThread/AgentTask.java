package Agent.testThread;

import Agent.Server.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AgentTask implements Runnable {

    String name;

    public AgentTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Socket clientToBackend = null;
        try {
            clientToBackend = new Socket("localhost",1234);
            Client client = new Client(clientToBackend);

            String line;
            String fileName="file.csv";///
            BufferedReader readFromFile = new BufferedReader(new FileReader(fileName));
            while((line = readFromFile.readLine())!= null) {
                System.out.println(line);
                client.sendMsg(line+"\n");
            }
            client.sendMsg("done");
            client.close(clientToBackend);
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
