package racingcar.model;

import racingcar.utils.NumberGenerator;

import static racingcar.model.Constant.Exceptions;
import static racingcar.model.Constant.IntegerConstant.ZERO;

public class Car {

    private final String name;
    private int distance = ZERO;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator generator) {
        validateCarNameLength(name);

        this.name = name;
        this.numberGenerator = generator;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public Car increaseDistance() {
        if (!availableForward()) {
            return null;
        }
        distance++;

        return this;
    }

    public boolean availableForward() {
        return Constant.Car.RANDOM_NUMBER_LIMIT <= numberGenerator.generate(Constant.Car.MAX_BOUND);
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 4) {
            throw new IllegalArgumentException(Exceptions.NOT_OVER_FIVE_CHARACTER);
        }
    }
}

