package tp_concurrency.realisation1;

public class Main {
    public static void main(String[] args) {
        Scheduler service = new Scheduler();
        for(int i = 0; i < 10 ; i++ ) {
            int x = i;
            service.manage((int j) -> System.out.println(x));
        }
    }
}
