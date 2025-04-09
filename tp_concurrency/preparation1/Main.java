package tp_concurrency.preparation1;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Summation summation = new Summation();
        summation.manage(10);

        FibonacciRec fibonacci = new FibonacciRec();
        fibonacci.soumettre(43);
    }
}
