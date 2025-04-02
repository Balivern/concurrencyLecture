package tp_concurrency.preparation1;

import tp_concurrency.realisation1.Scheduler;

public class Main {
    public static void main(String[] args) {
        tp_concurrency.realisation1.Scheduler service = new Scheduler();
        service.manage((i) -> System.out.println());
    }
}
