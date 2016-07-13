package AnonymousClass;

/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/12/16
 * Time:8:48 PM
 * Project:Thread_1
 */
public class AnonymousClass {
    public static void main(String []args)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println("Hello "+i);

                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
