package Agent.Controller;

import java.util.Observer;

public interface Controller extends Observer {
    public void viewCommand(String command);
    public void modelCommand(String command);
}
