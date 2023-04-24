package racingcar.car;

import racingcar.random.RandNum;
import racingcar.random.RandomGenerator;

public class Car {
    private final static int MIN_RANDOM_VALUE = 0;
    private final static int MAX_RANDOM_VALUE = 9;
    private final static int MAX_NAME_LEN = 5;
    private final static int MOVE_CRITERIA = 4;
    private final String name;
    private int location;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        if (name.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.location = location;
    }

    public int location() {
        return this.location;
    }

    public String name() {
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
}
