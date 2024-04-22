import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Semaphore semaphore = new Semaphore(2);

        Worker worker1 = new Worker("Раб1", semaphore);
        Worker worker2 = new Worker("Раб2", semaphore);
        Worker worker3 = new Worker("Раб3", semaphore);
        Worker worker4 = new Worker("Раб4", semaphore);
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();

        System.out.println("Все задачи выполнены. Доступные разрешения семафора: "
                + semaphore.availablePermits());
    }
}