package tp_concurrency.preparation1;

import java.util.concurrent.*;

public class Fibonacci {

    private static ExecutorService service = Executors.newCachedThreadPool();

    // Méthode pour soumettre un calcul Fibonacci
    public Future<Long> soumettre(int n) {
        Callable<Long> task = () -> {
            System.out.println("Démarrage du calcul de Fibonacci pour n = " + n);
            return calculerFibonacci(n);
        };
        return service.submit(task);
    }

    // Fonction statique pour calculer Fibonacci
    private static long calculerFibonacci(int n) {
        if (n <= 1) return n;
        long first = 0, second = 1, fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = first + second;
            first = second;
            second = fib;
        }
        return fib;
    }

    // Méthode qui récupère le résultat sans attente explicite
    public long soumettre() throws ExecutionException, InterruptedException {
        Future<Long> future = soumettre(10);
        // Utilisation de Future pour récupérer le résultat dès qu'il est prêt
        return future.get();
    }
}
