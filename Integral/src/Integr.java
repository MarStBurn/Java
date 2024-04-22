import java.util.ArrayList;
import java.util.List;

public class Integr {
    public static List<Double> Value(int n) {
        List<Double> list = new ArrayList<>();
        double from = 0.0, to = 4.0;
        double funcValues;
        double h = (to - from) / n;
        double integral;
        for (int i = 0; i < n; i++) {
            from += h;
            funcValues = Math.pow(Math.E, from) - from * from * from;
            integral = h * funcValues;
            list.add(integral);
        }
        return list;
    }
}
