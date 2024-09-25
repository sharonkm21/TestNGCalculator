package DesignPatternHomeTasks.One;

public class HomeTask_One
{
    public static void main (String[] args)
    {
        // Create multiple threads to simulate concurrent access to the singleton
        Thread t1 = new Thread(new CandyMakerUser(), "Thread-1");
        Thread t2 = new Thread(new CandyMakerUser(), "Thread-2");
        Thread t3 = new Thread(new CandyMakerUser(), "Thread-3");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }
}

class CandyMakerUser implements Runnable {
    @Override
    public void run() {
        // Get the singleton instance of CandyMaker
        CandyMaker candyMaker = CandyMaker.getInstance();
        System.out.println(Thread.currentThread().getName() + " acquired the CandyMaker instance: " + candyMaker);

        synchronized (candyMaker) {
            // Demonstrating the fill, boil, and drain process
            if (candyMaker.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " is filling the CandyMaker.");
                candyMaker.fill();
            }

            if (!candyMaker.isBoiled()) {
                System.out.println(Thread.currentThread().getName() + " is boiling the mixture.");
                candyMaker.boil();
            }

            if (!candyMaker.isEmpty() && candyMaker.isBoiled()) {
                System.out.println(Thread.currentThread().getName() + " is draining the CandyMaker.");
                candyMaker.drain();
            }
        }
    }
}
