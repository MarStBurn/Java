

import java.util.concurrent.*;


public class RandSum implements Callable<Double> {

@Override
    public Double call() {

        double a;
        double sum = 0;

            for (int i = 0; i < 10; i++) {

                a = Math.random()*1000 ;
                sum = sum + a ;


            }


            System.out.println("sum = " + sum);
            return sum;

        }

    }