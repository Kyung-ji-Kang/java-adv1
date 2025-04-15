package thread.start;

public class HelloThread extends Thread{

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" : run()");
    }
}
