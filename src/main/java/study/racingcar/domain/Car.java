package study.racingcar.domain;

import study.racingcar.strategy.NumberGenerator;

public class Car {
    private final Position position;
    private final CarName carName;

    public static final int MOVABLE_LOWER_BOUND = 4;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public static boolean isMovable(NumberGenerator numberGenerator) {
        int value = numberGenerator.generate();
        return value >= MOVABLE_LOWER_BOUND;
    }

    public void move() {
        position.increase();
    }

    public String getCarName() {
        return carName.toString();
    }

    public int getPosition() {
        return Integer.parseInt(position.toString());
    }

    public boolean isWinner(int maxPosition) {
        return position.isSame(maxPosition);
    }
}