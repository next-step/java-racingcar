package carracing.domain;

import java.util.Random;

public class Car {

    private static final int MIN_MOVE_CONDITION = 4;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private final Name name;
    private final Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public String getName() {
        return name.get();
    }

    public int getLocation() {
        return this.location.get();
    }

    public void go() {
        if (getRandomNumber() >= MIN_MOVE_CONDITION) {
            this.location.plus();
        }
    }

    public boolean isLocated(int distance) {
        return this.location.get() == distance;
    }

    protected int getRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER);
    }
}
