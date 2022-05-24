package Agent.Server;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;


    public Client(Socket socket){
        this.socket=socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (IOException e){}
    }

    public void sendMsg(String line){
        try {
            if (socket.isConnected()){
                out.write(line);
                out.flush();
                if(line=="done"){
                    close(socket);
                }
            }
        }catch (IOException e){}
    }


    public void close(Socket socket){
        try{
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.close();
            }
            if(socket!=null){
                socket.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}

