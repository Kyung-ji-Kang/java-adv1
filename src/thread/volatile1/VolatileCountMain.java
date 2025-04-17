package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask work = new MyTask();
        Thread t = new Thread(work, "work");
        t.start();
        sleep(1000);

        work.flag = false;
        log("flag = "+ work.flag +", count = "+work.count+" in main");


    }

    static class MyTask implements  Runnable{
        /* boolean flag = true;
         long count ;*/

        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {
            while(flag){
                count++;
                //1억번에 한번씩 출력
                if (count% 100_000_000==0){
                    log("flag = "+ flag +", count = "+count+" in while()");
                }
            }
            log("flag = "+ flag +", count = "+count+" 종료");
        }

    }
}
