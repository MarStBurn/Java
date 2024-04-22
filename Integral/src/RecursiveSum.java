import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Double> {
    static final int THRESHOLD = 10000;
    List<Double> list;
    int begin;
    int end;

    public RecursiveSum (List<Double> list, int begin, int end) {
        super();
        this.list = list;
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Double compute() {
        final int size = end - begin;
        if (size < THRESHOLD) {
            Double sum = 0.0;
            for (int i = begin; i < end; i++)
                sum += list.get(i);
            return sum;

        } else {
            final int middle = begin + ((end - begin) / 2);
            RecursiveSum sum1 = new RecursiveSum(list, begin, middle);
            sum1.fork();
            RecursiveSum sum2 = new RecursiveSum(list, middle, end);
            return sum2.compute() + sum1.join();
        }
    }
}