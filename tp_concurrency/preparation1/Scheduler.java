package tp_concurrency.preparation1;

import tp_concurrency.realisation1.Behavior;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    private ExecutorService service = Executors.newCachedThreadPool();

    public void manage(Behavior behavior) {
        Runnable taskDeclaration = () -> {
            System.out.println("Starting...");
            behavior.step(10);
            manage(behavior);
        };
        service.submit(taskDeclaration);
    }

}
