import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * Created by IntelliJ IDEA.
 * User:Mrigank
 * Date:6/14/16
 * Time:8:30 PM
 * Project:ThreadPool
 */

class Processor implements Runnable {
/*
Thread pools are used for managing lots of thread at same time
 */
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        System.out.println("Completed: " + id);
    }
}


public class threadPool {

    public static void main(String[] args) {
/*
ExecutorService abstracts away many of the complexities associated with the lower-level abstractions like raw Thread.
It provides mechanisms for safely starting, closing down,submitting, executing, and blocking on the successful or abrupt
termination of tasks (expressed as Runnable or Callable).And you can also avoid overhead.
 */
        //here 2 indicates number of worker in a factory
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();
        System.out.println("All tasks submitted.");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
        }

        System.out.println("All tasks completed.");
    }
}