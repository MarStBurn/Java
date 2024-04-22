 class Buffer {
    private int value = 0;
    private boolean full = false;
    public synchronized void put (int a) throws InterruptedException {
        while (full)
            wait();
        value= a;
        full = true;
        notifyAll();
    }
    public synchronized int get () throws InterruptedException {
        int result;
        while (!full)
            wait();
        result = value;
        full = false;
        notifyAll();
        return result;
    }
}
