package edu.nextstep.racingcar.step3.app;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.error.CarError;
import edu.nextstep.racingcar.step3.util.Randoms;

public class Car implements Vehicle {

    private final int threshold;
    private final Randoms randoms;
    private int distance = 1;

    public Car(Integer threshold, Randoms randoms) {

        validate(randoms.getNumberOfRandoms(), threshold);

        this.randoms = randoms;
        this.threshold = threshold;
    }

    private void validate(Integer numberOfRandoms, Integer threshold) {
        if (numberOfRandoms <= threshold) {
            throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
        }
    }

    public boolean isMove() {
        Integer randomNumber = randoms.getRandomNumber();
        return randomNumber >= threshold;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }
}
