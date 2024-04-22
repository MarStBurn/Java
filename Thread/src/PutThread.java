 class PutThread extends Thread {
    Buffer buf;
    public PutThread ( Buffer b) { buf = b; }
    public void run() {
        try {
            buf.put(10);
            buf.put(20);
            buf.put(30);
        }catch ( InterruptedException e) {
            System.out.println ("Поток прерван, не закончив запись в буфер");
        }
    }

}
