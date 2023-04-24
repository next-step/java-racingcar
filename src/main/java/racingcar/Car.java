package racingcar;

import racingcar.util.RandomGenerator;

public class Car {
    private final static int MIN_RANDOM_VALUE = 0;
    private final static int MAX_RANDOM_VALUE = 9;
    private final static int MOVE_CRITERIA = 4;
    private final String name;
    private int location;

    public static Car of(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        return new Car(name, 0);
    }

    private Car(String name, int location) {
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
}
