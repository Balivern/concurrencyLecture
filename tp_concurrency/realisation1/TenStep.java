package tp_concurrency.realisation1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TenStep {

    private ExecutorService service = Executors.newCachedThreadPool();

    public void manage(StoppingBehavior stop) {
        Runnable taskDeclaration = () -> {
            stop.step();
            if (!stop.wantsToStop()) manage(stop);
        };
        service.submit(taskDeclaration);
    }
}
