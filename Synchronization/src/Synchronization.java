/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/12/16
 * Time:9:29 PM
 * Project:Synchronization
 */

/*
every object in java has intrinsic lock or monitor lock or mutex , if you call synchronized block you have to acquire
intrinsic lock and only one thread can acuire intrinsic lock at a time .

Thus if one thread is updating any variable then other thread has to wait until resource has been released .
In brief Synchronized keyword is used to coordinate actions between threads.

 */
public class Synchronization {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread2.start();

        try {
            /*
            -The main thread creates and starts the thread1 and thread2 threads. The two threads start running in parallel.
            -The main thread calls thread1.join() to wait for the t1 thread to finish.
            -The thread1 thread completes and the thread1.join() method returns.
            -The main thread calls thread2.join() to wait for the thread2 thread to finish.
             */
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
    public static void main(String[] str){
        Synchronization syn = new Synchronization();
        syn.run();
    }
}
