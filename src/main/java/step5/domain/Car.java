package step5.domain;

import java.util.Objects;
import java.util.Random;

public class Car {

    private static final int RANDOM_VALUE = 10;
    private static final int WORD_MAX_LENGTH = 5;
    private static final int CONST_FOUR = 4;
    private final String name;
    private int position = 0;

    public Car(final String name, int position) {
        if (name.length() > WORD_MAX_LENGTH) {
            throw new IllegalArgumentException("5글자 초과 입력하실 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public boolean isExceedWord() {
        if (name.length() > 5) {
            return true;
        }
        return false;
    }

    public void move() {
        if (generateRandomValue() >= CONST_FOUR) {
            this.position++;
        }
    }

    protected int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(RANDOM_VALUE);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
}
