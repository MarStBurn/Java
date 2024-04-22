import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private String name;
    private Semaphore semaphore;
    public Worker(String name, Semaphore semaphore) {
        super(name);
        this.name = name;
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        System.out.println("Запуск " + name + "...");
        try {
            System.out.println(name + " предоставляется разрешение, доступные разрешения семафора: "
                    + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(name + " получает разрешение.");
            for (int i=0; i < 3; i++) {
                System.out.println(name + " выполняет операцию " + (i + 1)
                        + ", доступные разрешения семафора: "
                        + semaphore.availablePermits());
                Thread.sleep( (long) (Math.random() * 1000));
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        semaphore.release();
        System.out.println(name + " освобождает разрешение, доступные разрешения семафора: "
                + semaphore.availablePermits());
    }
}