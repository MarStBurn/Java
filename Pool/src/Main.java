import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Future<Double>> list = new ArrayList<Future<Double>>();

        Callable<Double> callable = new RandSum();

        double ssum = 0;
        for(int i=0; i< 6; i++){

            Future<Double> future = executor.submit(callable);

            list.add(future);
        }
        for(Future<Double> fut : list){
            try {
                ssum = ssum + fut.get();
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        System.out.println("Сумма5 = " + ssum);
    }
}