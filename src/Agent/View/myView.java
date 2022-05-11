package Agent.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.List;

public class myView extends Observable implements View {
   private HashMap<String,List<String>> commands;
   String[] commandSec;
   List<String> vals;

   @Override
   public void setCommands() {
      commands= new HashMap<>();
   }

   @Override
   public HashMap<String, List<String>> getCommands() {
      return commands;
   }

   @Override
   public void updateCommands(String[] newCommand) {
      String com = newCommand[0];
      String val = newCommand[1];
      if(commands.containsKey(com)){
         commands.get(com).add(val);
         setChanged();
         notifyObservers(com);
      }
      else if(!commands.containsKey(com)){
         vals=new ArrayList<>();
         vals.add(val);
         commands.put(com, vals);
         setChanged();
         notifyObservers(com);
      }
   }

   @Override
   public String[] inputCommand(String text) {
      String s = text.substring(15);
      commandSec = s.split(" ");
      return commandSec;
   }

   @Override
   public void Display(String result) {
      System.out.println(result);
   }
}
