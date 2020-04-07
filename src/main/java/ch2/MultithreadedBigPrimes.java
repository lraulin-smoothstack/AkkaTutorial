package ch2;

import java.util.ArrayList;
import java.util.List;

public class MultithreadedBigPrimes {
    private static final int NUMBER_OF_PRIMES = 100;

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();

        Results results = new Results();

        Runnable status = new CurrentStatus(results);
        Thread statusTask = new Thread(status);
        statusTask.start();

        Runnable task = new PrimeGenerator(results);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PRIMES; i++) {
            Thread t = new Thread(task);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        results.print();

        Long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms.");
    }
}
