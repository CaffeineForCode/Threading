import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/14/16
 * Time:8:42 PM
 * Project:CountDownLatches
 */


/*
CountDownLatch works in latch principle, main thread will wait until gate is open. One thread waits for n number of
threads specified while creating CountDownLatch in Java.
Any thread, usually main thread of application, which calls CountDownLatch.await() will wait until count reaches zero
or its interrupted by another thread. All other thread are required to do count down by calling CountDownLatch.countDown()
once they are completed or ready.
*/

class Processor implements Runnable{
    private CountDownLatch latch;
    public Processor(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        System.out.println("Starting...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();

    }
}

public class countDownLatches {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executer = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++){
            executer.submit(new Processor(latch));
        }

        try {
            latch.await();//wait until countdown to 0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed.");
    }
}
