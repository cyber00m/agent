package Agent.View;

import java.util.HashMap;
import java.util.List;

public interface View {
    public void setCommands();
    public HashMap<String,List<String>> getCommands();
    public void updateCommands(String[] newCommand);
    public String[] inputCommand(String text);
    public void Display(String result);
}
