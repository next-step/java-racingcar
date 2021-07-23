package edu.nextstep.racingcar.step3.app;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.error.CarError;
import edu.nextstep.racingcar.step3.util.RandomUtils;
import edu.nextstep.racingcar.step3.util.Randoms;

public class Car implements Vehicle {

    private Integer numberOfRandoms = 10;
    private Integer threshold = 4;
    private Randoms randomUtils = new RandomUtils();;
    private Integer distance = 1;

    public Car() {
    }

    public Car(Integer numberOfRandoms, Integer threshold) {

        if (numberOfRandoms <= threshold) {
            throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
        }

        this.numberOfRandoms = numberOfRandoms;
        this.threshold = threshold;
    }

    public Car(Integer numberOfRandoms, Integer threshold, Randoms randomUtils) {

        if (numberOfRandoms <= threshold) {
            throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
        }

        this.numberOfRandoms = numberOfRandoms;
        this.threshold = threshold;
        this.randomUtils = randomUtils;
    }

    public boolean isMove() {
        Integer randomNumber = randomUtils.getRandomNumber(numberOfRandoms);
        return randomNumber >= threshold;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }
}
