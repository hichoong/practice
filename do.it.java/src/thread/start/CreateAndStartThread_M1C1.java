package thread.start;

//방법1 Thread 클래스 상속하여 클래스 생성 case1 : 2개의 쓰레드 생성
class SMIFileThread extends Thread {
    @Override
        public void run() {
        //#2 자막 번호 하나~5
        String[] strArray = {"하나","둘","셋","넷","다섯"};
        try{Thread.sleep(30);} catch (InterruptedException e) {}
        //#4 자막번호  출력
        for(int i=0; i< strArray.length; i++) {
            System.out.println(" - (자막번호)"+strArray[i]);
            try{Thread.sleep(200);} catch (InterruptedException e) {}
        }
    }
}

public class CreateAndStartThread_M1C1 {
    public static void main(String[] args) {

        //SMIFileThread 객체 생성 및 시작
        Thread smiFileThread = new thread.start.SMIFileThread();
        smiFileThread.start();
        //#1 비디오프레임1~5
        int[] intArray = {1,2,3,4,5};
        //#3 비디오 프레임 출력
        for(int i=0; i<intArray.length; i++) {
            System.out.print("(비디오프레임)"+intArray[i]);
            try{Thread.sleep(200);} catch (InterruptedException e) {}
        }


    }
}