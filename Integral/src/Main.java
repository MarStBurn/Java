import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        List<Double> list = Integr.Value(1000);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        RecursiveSum recursiveSum = new RecursiveSum(list, 0, list.size());
        double recSum = forkJoinPool.invoke(recursiveSum);
        System.out.println("Integral = " + recSum);
    }
}