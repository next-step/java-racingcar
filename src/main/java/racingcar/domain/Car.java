package racingcar.domain;

public class Car {

    private static final int RUNNABLE_BOUND = 4;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    private CarName name;
    private int distance;
    private Randomable randomable;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = 0;
        this.randomable = new RandomNumber();
    }

    public Car(String name,Randomable randomable) {
        this.name = new CarName(name);
        this.distance = 0;
        this.randomable = randomable;
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

    public String showName() {
        return name.toString();
    }

    private boolean isRunnable() {
        return RUNNABLE_BOUND <= randomable.getIntInRange(MIN_VALUE, MAX_VALUE);
    }

    public String showGraph(String figure) {
        return this.name + ":" + figure.repeat(this.distance);
    }

}
