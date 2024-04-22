public class Main {
    public static void main(String[] args) {
        Buffer buf = new Buffer();
        Thread p1 = new PutThread(buf);
        Thread p2 = new PutThread(buf);
        Thread p3 = new PutThread(buf);
        Thread p4 = new PutThread(buf);
        Thread p5 = new PutThread(buf);
        Thread g1 = new GetThread(buf);
        Thread g2 = new GetThread(buf);
        Thread g3 = new GetThread(buf);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        g1.start();
        g2.start();
        g3.start();
    }
}