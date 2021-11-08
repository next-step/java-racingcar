package racingcar.step4.domain;

import racingcar.step4.move.Moving;

import java.util.Objects;
import java.util.Random;

/**
 * Car(자동차) 클래스
 * 2021.11.04
 * 01.v
 */

public class Car {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 4;
    private String name;
    private int position;

    public Car(String name) {
        this(name, 1);
    }

    public Car(String name, int position) {
        carNamingCheck(name);
        this.name = name;
        this.position = position;
    }
    public int getPosition() {
        return position;
    }


    public void move(Moving moving) {
        if (moving.isMovable()) {
            this.position++;
        }
    }

    private void carNamingCheck(String name) {
        if (name == null || name.length() > 5 || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
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

    // 테스를 위한 메서드
    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_NUM);
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

    public String getName() {
        return name;
    }
}
