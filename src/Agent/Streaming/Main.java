package Agent.Streaming;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        toFG fg = new toFG("props.txt");
        Scanner s = new Scanner(System.in);
        String line;
        while((line = s.nextLine())!= "done") {
            if(line.contains("rudder")){
                System.out.println(Double.parseDouble(line.split(" ")[1]));
                fg.setRudder(Double.parseDouble(line.split(" ")[1]));
            }
        }
    }
}

