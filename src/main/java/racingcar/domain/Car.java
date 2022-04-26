package racingcar.domain;

import racingcar.exception.CarNameException;

public class Car {

    private static final int MAX_LENGTH = 5;
    private final String name;
    private final Position position;

    public Car(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new CarNameException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.position = new Position();
    }

    public void moveOrStop(RacingStrategy racingStrategy) {
        if (racingStrategy.checkCondition()) {
            position.move();
        }
    }

    public boolean isWinner(int max) {
        return position.getMovement() == max;
    }

    public int getMaxPosition(int max) {
        return Math.max(position.getMovement(), max);
    }

    public int getPosition() {
        return position.getMovement();
    }

    public String getName() {
        return name;
    }

}
