package thread.control;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();

    }

    static class CHerckedRUnnable implements  Runnable{

        @Override
        public void run() {
            //throw new Exception();

        }
    }
}
