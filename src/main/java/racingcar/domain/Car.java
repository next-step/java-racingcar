package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;

public class Car {

    private static final int MOVABLE_THRESHOLD = 4;

    private int position;

    private String name;

    private int attempt;

    public Car(String name) {
        if (this.isInvalidName(name)) {
            throw new IllegalArgumentException("입력된 이름이 유효하지 않습니다 [name: " + name + "]");
        }

        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name == null || name.length() > 5;
    }

    public void move(MovingStrategy strategy) {
        if (strategy.isMovable()) {
            position++;
        }
        attempt++;
    }

    private boolean isOutOfBound(int randomInt) {
        return randomInt < 0 || randomInt > 9;
    }

    private boolean isMovable(int randomInt) {
        return randomInt >= MOVABLE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Record extractRecord() {
        return new Record(name, position, attempt);
    }
}
