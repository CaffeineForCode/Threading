package ThreadClass;

/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/12/16
 * Time:8:44 PM
 * Project:Thread_1
 */


//Implementing runnable interface
class runner implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Hello "+i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class ThreadClass {
    public static void main(String[] args){
        Thread thread1 = new Thread(new runner());
        thread1.start();
        Thread thread2 = new Thread(new runner());
        thread2.start();

    }
}
