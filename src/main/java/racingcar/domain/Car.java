package racingcar.domain;

import racingcar.exception.CarNameException;

public class Car {

    private static final int MAX_LENGTH = 5;
    private String name;
    private int movement = 0;

    public Car() {
    }

    public Car(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new CarNameException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    public int moveOrStop(RacingStrategy racingStrategy, int value) {
        if (racingStrategy.checkCondition(value)) {
            movement++;
        }
        return movement;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

}
