import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class FactorialTask extends RecursiveAction {
    private static int SEQUENTIAL_THRESHOLD = 5;
    private List<BigInteger> integerList;
    public FactorialTask (List<BigInteger> integerList) {
        this.integerList = integerList;
    }

    @Override
    protected void compute () {
        if (integerList.size() <= SEQUENTIAL_THRESHOLD) {
            showFactorials();
        } else {
            int middle = integerList.size() / 2;
            List<BigInteger> newList = integerList.subList(middle, integerList.size());
            integerList = integerList.subList(0, middle);
            FactorialTask task = new FactorialTask(newList);
            task.fork();
            this.compute();
        }
    }
    private void showFactorials () {
        for (BigInteger i : integerList) {
            System.out.println( i + "! = " + CalcUtil.calculateFactorial(i));
            try { //sleep to simulate long running task
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}