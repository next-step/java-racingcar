package racingcar.step5.domain;

import java.util.Objects;

/**
 * Car(자동차) 클래스
 * 2021.11.04
 * 01.v
 */

public class Car {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 4;
    private Name name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // 테스를 위한 메서드
    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    // 테스를 위한 메서드
    private boolean isMovable(int number) {
        return MIN_NUM <= number & number <= MAX_NUM;
    }

}
