package thread.property;

//쓰레드 객체 가져오기, 이름설정, 쓰레드 수
public class ThreadProperty1 {
    public static void main(String[] args) {
        //1. 객체가져오기(crrentThread) 쓰레드 수 : activeCount()
//        Thread curThread = Thread.currentThread();
//        System.out.println("현재 쓰레드의 이름 = "+curThread.getName());
        System.out.println("동작하는 쓰레드 수 ="+Thread.activeCount());

        //2. 쓰레드 이름 지정(자동)
        for (int i=0; i<3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }
        //3. 쓰레드 이름 지정 (수동)
        for (int i=0; i<3; i++) {
            Thread thread = new Thread();
            thread.setName(i+"번째 쓰레드");
            System.out.println(thread.getName());
            thread.start();
        }
        //4. 쓰레드 이름 지정(자동)
        for (int i=0; i<3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }
        //5. 쓰레드 수
        System.out.println("동작하는 쓰레드 수 ="+Thread.activeCount());

    }

}
