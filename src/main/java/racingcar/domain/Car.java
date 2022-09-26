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

    public int showDistance() {
        return this.distance;
    }

    public CarName showName() {
        return name;
    }

    private boolean isRunnable() {
        return RUNNABLE_BOUND <= randomable.getIntInRange(MIN_VALUE, MAX_VALUE);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
