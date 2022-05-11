package Agent.Controller;

import Agent.Model.Model;
import Agent.View.myView;

import java.util.Observable;

public class myController implements Controller {
    myView view;
    Model model;
    String parameterNameV,parameterNameM;
    Float val;

    @Override
    public void update(Observable o, Object arg) {
        ///updating each function to who sent the request and who handles the request
        if(o.getClass().isInstance(view)){
            parameterNameV =arg.toString();
            viewCommand(parameterNameV);
        }
        if(o.getClass().isInstance(model)){
            parameterNameM=arg.toString();
            modelCommand(parameterNameM);
        }
    }


    @Override
    public void viewCommand(String command) {
        int length = view.getCommands().get(parameterNameV).size()-1;
        val =Float.parseFloat(String.valueOf(view.getCommands().get(parameterNameV).indexOf(length)));
        switch (parameterNameV){
            case "aileron":
                model.setAileron(val);
            case "throttle":
                model.setThrottle(val);
            case "rudder":
                model.setThrottle(val);
            case "elevator":
                model.setThrottle(val);
            case "breaks":
                model.setBreaks(val);
        }
    }

    @Override
    public void modelCommand(String command) {
        switch (parameterNameM){
            case "aileron":
                view.Display(parameterNameM.concat(" "+model.getAileron()));
            case "throttle":
                view.Display(parameterNameM.concat(" "+model.getThrottle()));
            case "rudder":
                view.Display(parameterNameM.concat(" "+model.getRudder()));
            case "elevator":
                view.Display(parameterNameM.concat(" "+model.getElevator()));
            case "breaks":
                view.Display(parameterNameM.concat(" "+model.getBreaks()));
        }
    }
}
