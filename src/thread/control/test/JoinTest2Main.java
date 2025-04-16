package thread.control.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinTest2Main {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");
        long now_tiem = System.currentTimeMillis();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long end_tiem = System.currentTimeMillis();

        long result = end_tiem - now_tiem;
        System.out.println("실행 시간: "+result/1000+"초");
        System.out.println("모든 스레드 실행 완료");
    }

    /*t1: 1
    * t1: 2
    * t1: 3
    *
    * t2: 1
     * t2: 2
     * t2: 3
     *
     * t3: 1
     * t3: 2
     * t3: 3
     * 모든 스레드 실행 완료
    * */

    static class MyTask implements Runnable{

        @Override
        public void run() {
            for(int i=1; i<=3 ; i++){
                log(i);
                sleep(1000);
            }
        }
    }
}
