package thread.start.test;

import static util.MyLogger.log;

public class testMain1 {
    public static void main(String[] args) {

        Thread thread = new CounterThread();
        thread.start();

    }

    public static class CounterThread extends  Thread{

        @Override
        public void run() {
            for(int i=1; i<=5; i++){
                log("value: "+i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }


    }

}
