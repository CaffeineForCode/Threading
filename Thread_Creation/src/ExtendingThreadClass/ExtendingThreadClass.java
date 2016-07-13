package ExtendingThreadClass;

/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/12/16
 * Time:8:33 PM
 * Project:Thread_1
 */
class Runner extends Thread {

    @Override
    public void run() {
       for(int i = 0; i < 10; i++ ){
           System.out.println("Hello "+i);

           try{
               //Sleep() function pause the thread for given number of milliseconds
               Thread.sleep(100);
           }catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

public class ExtendingThreadClass{

    public static void main(String[] args){
        /*
        Main use of thread is to run program concurrently
            -Additionally we can't use ExtendingThreadClass.Runner.run() because it will call the main thread
            -Thus we call start() method, to run current thread
         */
        Runner runner1 =new Runner();
        runner1.start();
        Runner runner2 =new Runner();
        runner2.start();

    }
}