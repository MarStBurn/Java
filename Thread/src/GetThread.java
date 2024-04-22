 class GetThread extends Thread {
    Buffer buf;
    public GetThread ( Buffer b) { buf = b; }
    public void run() {
        try {
            for (int i = 0; i<6; i++) {
                System.out.println (buf.get());
            }
        } catch ( InterruptedException e) {
            System.out.println("Поток прерван, не завершив чтение из буфера");
        }
    }
}
