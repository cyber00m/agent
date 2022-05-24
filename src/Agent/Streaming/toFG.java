package Agent.Streaming;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class toFG {
    HashMap<String, String> properties;
    Socket fg;
    PrintWriter out2fg;

    public toFG(String propertiesFileName){
        properties = new HashMap<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(propertiesFileName));
            String line;
            while((line = in.readLine()) !=null){
                String sp[] = line.split(",");
                properties.put(sp[0],sp[1]);
            }
            in.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(properties.get("port"));
        try {
            fg = new Socket(properties.get("ip"), port);
            out2fg = new PrintWriter(fg.getOutputStream());
            System.out.println("connected to fg!");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setAileron(double x){
        String command = properties.get("aileron");
        out2fg.println(command+ " "+x);
        out2fg.flush();
    }

    public void setElevators(double x){
        String command = properties.get("elevators");
        out2fg.println(command+ " "+x);
        out2fg.flush();
    }

    public void setRudder(double x){
        String command = properties.get("rudder");
        out2fg.println(command+ " "+x);
        out2fg.flush();
    }

    public void setThrottle(double x){
        String command = properties.get("throttle");
        out2fg.println(command+ " "+x);
        out2fg.flush();
    }

    @Override
    protected void finalize(){
        try {
            out2fg.close();
            fg.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
