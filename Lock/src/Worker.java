import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable
{
    String name;
    ReentrantLock re;
    public Worker(ReentrantLock rl, String n)
    {
        re = rl;
        name = n;
    }
    public void run()
    {
        boolean done = false;
        while (!done)
        {
            boolean ans = re.tryLock();
            if(ans)
            {
                try
                {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Задачей " + name + " получена внешняя блокировка в "
                            + ft.format(d) + " Выполнение внешней задачи");
                    Thread.sleep(1500);
                    re.lock();
                    try
                    {
                        d = new Date();
                        ft = new SimpleDateFormat("hh:mm:ss");
                        System.out.println("Задачей " + name + " получена внутренняя блокировка в "
                                + ft.format(d) + " Выполнение внутренней задачи");
                        System.out.println("Число удерживаемых блокировок - "+ re.getHoldCount());
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                        //Inner lock release
                        System.out.println("С задачи " + name +
                                " снимается внутренняя блокировка");
                        re.unlock();
                    }
                    System.out.println("Число удерживаемых блокировок - " + re.getHoldCount());
                    System.out.println("Задача " + name + " выполнена");
                    done = true;
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    //Outer lock release
                    System.out.println("С задачи " + name +
                            " снимается внешняя блокировка");
                    re.unlock();
                    System.out.println("Число удерживаемых блокировок - " +
                            re.getHoldCount());
                }
            }
            else
            {
                System.out.println("Задача " + name + " ожидает блокировку");
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
