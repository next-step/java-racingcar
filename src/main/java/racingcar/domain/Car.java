package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car  implements Cloneable {
    public static final int CAR_NAME_SIZE = 5;

    private String name;
    private int position;

    public Car() {
        this.position = 1;
    }

    public Car(String name) {
        validName(name);
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    private void validName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈값일 수 없습니다.");
        }
        if (name.length() > CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
