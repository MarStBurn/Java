import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.math.BigInteger;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<BigInteger> list = new ArrayList<>();
        for (int i = 3; i < 20; i++) {
            list.add(new BigInteger(Integer.toString(i)));
        }
        ForkJoinPool.commonPool().invoke(new FactorialTask(list));
    }
}