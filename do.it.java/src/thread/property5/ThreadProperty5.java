package thread.property5;

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(getName() + " : " + (isDaemon()? "데몬쓰레드" : "일반쓰레드"));
        for (int i=0; i<6; i++) {
            System.out.println(getName() + " : " + i + "초");
            try {Thread.sleep(1000);} catch (InterruptedException e) {}
        }
    }
}

public class ThreadProperty5  {
    public static void main(String[] args) {
        //1. 일반쓰레드
        Thread thread1 = new MyThread();
        thread1.setDaemon(false);
        thread1.setName("thread1");
        thread1.start();
        //2. 데몬쓰레드
        Thread thread2 = new MyThread();
        try{thread2.setDaemon(true);} catch (IllegalThreadStateException e) {}
        thread2.setName("thread2");
        try{thread2.start();} catch (IllegalThreadStateException e) {}

        //3. 3초 후 쓰레드 종료
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        System.out.println("메인 쓰레드 종료");
    }

}