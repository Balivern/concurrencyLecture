package tp_concurrency.preparation1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Summation {

    private ExecutorService service = Executors.newCachedThreadPool();

    public void manage(int n) {
        Runnable taskDeclaration = () -> {
            System.out.println("Starting...");
            int mySum = IntStream.range(1,n+1).sum();
            System.out.println("Somme de 1 à " + n + " : " + mySum);
        };
        service.execute(taskDeclaration);
    }
}
