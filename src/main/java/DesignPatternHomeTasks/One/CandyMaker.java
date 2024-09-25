package DesignPatternHomeTasks.One;

public class CandyMaker {

    private static volatile CandyMaker instance;

    private boolean empty;
    private boolean boiled;

    // Private constructor to prevent external instantiation
    private CandyMaker() {
        empty = true;
        boiled = false;
    }

    public static CandyMaker getInstance() {
        if (instance == null) {
            synchronized (CandyMaker.class) {
                if (instance == null) {
                    instance = new CandyMaker();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the content to boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}