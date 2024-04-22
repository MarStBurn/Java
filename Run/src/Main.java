import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(final String[] arguments) throws InterruptedException {

        final ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        final ScheduledFuture<?> beepHandler = scheduler.scheduleAtFixedRate(new Brig(), 10, 2, TimeUnit.SECONDS);

        // Просим исполнителя выполнить задачу, описанную в методе run().
        // Эта задача через 10 секунд попросит отменить выполнение задачи BeepTask
        // и остановить исполнителя.
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {

                // Используя объект beepHandler типа ScheduledFuture<?>
                // просим отменить задачу BeepTask
                beepHandler.cancel(true);
                System.out.println("");
                System.out.println("Отмена выполнения задачи");

                // Останавливаем исполнителя
                scheduler.shutdown();
                System.out.println("Исполнитель остановлен");
            }
        }, 20, TimeUnit.SECONDS);
    }
}