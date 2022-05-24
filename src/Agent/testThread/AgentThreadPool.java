package Agent.testThread;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AgentThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                AgentTask at = new AgentTask("task agent");
                executor.execute(at);
                System.out.println(at.name + " created \n");
            } else {
                Task t = new Task("task "+i);

                System.out.println(t.name + " created");
                executor.execute(t);
            }
        }
        executor.shutdown();
    }
}
