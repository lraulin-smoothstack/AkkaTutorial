package ch2;

public class CurrentStatus implements Runnable {
    private final int NUMBER_OF_PRIMES = 100;
    private Results results;

    public CurrentStatus(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        while (results.getSize() < NUMBER_OF_PRIMES) {
            System.out.println("Got " + results.getSize() + " so far...");
            results.print();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
