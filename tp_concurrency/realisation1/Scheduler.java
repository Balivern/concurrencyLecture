package tp_concurrency.realisation1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    private ExecutorService service = Executors.newCachedThreadPool();

    public void manage(Behavior behavior) {
        Runnable taskDeclaration = () -> {
            behavior.step(10);
            manage(behavior);
        };
        service.submit(taskDeclaration);
    }

}
