package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {

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

    public Car(String name, Randomable randomable) {
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

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.distance, this.distance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car o = (Car) obj;
            return this.name.equals(o.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
