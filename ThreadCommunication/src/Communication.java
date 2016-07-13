/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/12/16
 * Time:9:06 PM
 * Project:ThreadCommunication
 */

/*
Two problem arises:
    -Data being cached
    -Threads intervening
    - Thus we use Volatile keyword (Mostly for thread communication and visibility and mutual exclusion)
 */

import java.util.Scanner;

class Processor extends Thread{

    private volatile boolean running = true;

        public void run(){

            while(running){
                System.out.println("hello");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    public void shutdown(){
        running = false;
    }
}


public class Communication {
    public static void main(String[] args){
        Processor pro = new Processor();
        pro.start();

        System.out.println("Press return to stop...");
        new Scanner(System.in).nextLine();

        pro.shutdown();


    }
}
