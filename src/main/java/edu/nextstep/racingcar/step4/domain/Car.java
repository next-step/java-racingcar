package edu.nextstep.racingcar.step4.domain;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step4.error.CarError;

public class Car {

    private int distance = 1;
    private final String name;
    private final int numberOfRandoms;
    private final int threshold;

    public Car(String name, int numberOfRandoms, int threshold) {
        validate(name, numberOfRandoms, threshold);

        this.name = name;
        this.numberOfRandoms = numberOfRandoms;
        this.threshold = threshold;
    }

    public void validate(String name, int numberOfRandoms, int threshold) {
        if (numberOfRandoms <= threshold) {
            throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
        }

        if (name.length() > 5) {
            throw new BusinessException(CarError.INVALID_VALUE_TOO_LONG_CAR_NAME);
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove(numberOfRandoms, threshold)) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
