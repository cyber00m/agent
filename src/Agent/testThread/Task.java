package Agent.testThread;


import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    String name;

    public Task(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        try{
            Long duration = (long) (Math.random()*10);
            TimeUnit.MILLISECONDS.sleep(duration);
            System.out.println(this.name + " #@$#@@#%@#%#@@#%@#%@#%@%@%#%#@#%@#@%#%@#@%%@#@%#%#@%#@%@#");
        }catch (InterruptedException e){}
    }
}

