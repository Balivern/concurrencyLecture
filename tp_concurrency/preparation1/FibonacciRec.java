package tp_concurrency.preparation1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibonacciRec{

    public long soumettre(int n) {
        ExecutorService service = Executors.newCachedThreadPool();

        Callable<Long> callable = () -> {
            System.out.println("Démarrage du calcul de Fibonacci pour n = " + n);
            return fibonacci(n);
        };

        Future<Long> future = service.submit(callable);

        long result = 0;
        try {
            result = future.get();
            System.out.println("Résultat pour n = " + n + " : " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        service.shutdown();
        return result;
    }

    public long fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}