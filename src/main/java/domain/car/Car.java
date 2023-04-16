package domain.car;

import domain.strategy.MovingStrategy;

public class Car {

    public static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;
    private int distance;

    public Car(String name) {
        checkLengthOfName(name);
        this.name = name;
    }

    private void checkLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름을 " +  MAX_LENGTH_OF_NAME + " 자 이하로 입력해주세요. : " + name);
        }
    }

    public void go(MovingStrategy strategy) {
        if (strategy.movable()) {
            this.distance++;
        }
    }

    public String name() {
        return this.name;
    }

    public int distance() {
        return this.distance;
    }
}
