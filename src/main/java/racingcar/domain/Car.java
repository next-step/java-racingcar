package racingcar.domain;

public class Car {

    private String name;
    private int distance;
    private Randomable randomable;

    private static final int RUNNABLE_BOUND = 4;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
        this.randomable = new RandomNumber();
    }

    public Car(Randomable randomable) {
        this.distance = 0;
        this.randomable = randomable;
    }

    public void run() {
        if (isRunnable()) {
            this.distance += 1;
        }
    }

    public int showDistance() {
        return this.distance;
    }

    public String showName() {
        return name;
    }

    private boolean isRunnable() {
        return RUNNABLE_BOUND <= randomable.getIntInRange(MIN_VALUE, MAX_VALUE);
    }
}
