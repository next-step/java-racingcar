package racingcar.car;

import racingcar.random.RandNum;
import racingcar.random.RandomGenerator;

public class Car {
    private final static int MIN_RANDOM_VALUE = 0;
    private final static int MAX_RANDOM_VALUE = 9;
    private final static int MOVE_CRITERIA = 4;
    private final static int DEFAULT_LOCATION = 0;

    private final Name name;
    private int location;

    public Car(String name) {
        this(name, DEFAULT_LOCATION);
    }

    public Car(String name, int location) {
        this.name = new Name(name);
        this.location = location;
    }

    public int location() {
        return this.location;
    }

    public Name name() {
        return this.name;
    }

    public void move() {
        RandNum randNum =
                RandomGenerator.generate(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        moveDependingOn(randNum);
    }

    private void moveDependingOn(RandNum randNum) {
        if (randNum.isGreaterThan(MOVE_CRITERIA)) {
            location++;
        }
    }

    public boolean isWinner(int maxLocation) {
        return this.location >= maxLocation;
    }

    public int maxLocation(int criteria) {
        return Math.max(this.location, criteria);
    }
}
