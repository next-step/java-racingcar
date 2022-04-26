package racingcar.domain;

import racingcar.exception.CarNameException;

public class Car {

    private static final int MAX_LENGTH = 5;
    private String name;
    private int movement = 0;

    public Car(String name, int movement) {
        if (name.length() > MAX_LENGTH) {
            throw new CarNameException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.movement = movement;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void moveOrStop(RacingStrategy racingStrategy) {
        if (racingStrategy.checkCondition()) {
            this.movement++;
        }
    }

    public boolean isWinner(int max) {
        return movement == max;
    }

    public int getMaxPosition(int max) {
        return Math.max(movement, max);
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

}
