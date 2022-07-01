package thread.property2;

    class MyThread extends Thread {
        @Override
        public void run() {
            for (long i=0; i<1000000000; i++) {}
            System.out.println(getName() + "우선순위 : "+ getPriority());
        }
    }

public class ThreadProperty2 {
    public static void main(String[] args) {
        //CPU core 확인하기
        System.out.println("코어수 : "+Runtime.getRuntime().availableProcessors());

        //1. 디폴트 우선순위
        for (int i=0; i<3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
        //2. 디폴트 우선순위 직접 지정
        for (int i=0; i<10; i++) {
            Thread thread = new MyThread();
            thread.setName(i+"번째 쓰레드");
            if (i == 9) thread.setPriority(10);
            thread.start();
        }





    }//메인 메서드
}//클래스
