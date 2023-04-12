package game.domain;

import game.domain.policy.CarMovePolicy;
import game.domain.policy.StandardCarMovePolicy;
import game.util.NumberGenerator;

public class Car {

    public static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String carName;
    private final CarMovePolicy carMovePolicy;
    private final NumberGenerator numberGenerator;

    private int position = 0;

    public Car(String carName, NumberGenerator numberGenerator) {
        this(carName, new StandardCarMovePolicy(), numberGenerator);
    }

    public Car(String carName, CarMovePolicy carMovePolicy, NumberGenerator numberGenerator) {
        throwIfLengthIsGreaterThanMax(carName);
        this.carName = carName;
        this.carMovePolicy = carMovePolicy;
        this.numberGenerator = numberGenerator;
    }

    private void throwIfLengthIsGreaterThanMax(String carName) {
        if (carName.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(String.format("자동차 이름은 5자를 초과할 수 없습니다.(%s)", carName));
        }
    }

    public void drive() {
        if (carMovePolicy.isMovable(numberGenerator.generate())) {
            position++;
        }
    }

    public int position() {
        return position;
    }

}