package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {

        // 현재 실행 중인 스레드 이름 출력 (main 스레드)
        System.out.println(Thread.currentThread().getName() + ": main() start");

        // 새로운 스레드 객체 생성 (아직 실행은 아님)
        HelloThread helloThread = new HelloThread("경지의 쓰레드1");

        System.out.println(Thread.currentThread().getName() + " : start() 호출 전");

        // 스레드 실행 시작. 여기서 run()이 아닌 start()를 호출해야 별도 스레드가 동작함
        helloThread.start(); // 이 시점부터 별도의 Thread-0이 실행될 준비를 함 (비동기)

        System.out.println(Thread.currentThread().getName()+" : start() 호출 후");

        // main 스레드 종료
        System.out.println(Thread.currentThread().getName() + ": main() end");

        // 이후 "Thread-0 : run()" 로그는 helloThread 내부의 run() 메서드 실행 결과
        // 이건 별도의 스레드(Thread-0)가 출력하는 것이지 main 스레드가 아님
    }
}
