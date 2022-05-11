package Agent.Model;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerMod{

    public interface ClientHandler{
        void handle(InputStream inFromClient,OutputStream outToClient);
	/*	default void Bye(OutputStream outToClient){
			try {
				outToClient.write("Bye".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
    }

    volatile boolean stop;
    private int _clientLim;

    public ServerMod() {
        stop=false;
    }

    private void startServer(int port, ClientHandler ch) {
        try{
            ServerSocket server= new ServerSocket(port);
            server.setSoTimeout(1000);
            while(!stop){
                try{
                    Socket client=server.accept();
                    ch.handle(client.getInputStream(),client.getOutputStream());
                    client.close();
                    //	ch.Bye(client.getOutputStream());

                }catch(SocketTimeoutException e){}
            }
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // runs the server in its own thread
    public void start(int port, ClientHandler ch) {
        new Thread(()->startServer(port,ch)).start();
    }

    public void stop() {
        stop=true;
    }
}
