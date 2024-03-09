package racingcar.domain.dto;

import racingcar.domain.vo.NumberOfCars;
import racingcar.domain.vo.NumberOfTrials;

public class RacingCarInput {
    private final NumberOfCars numberOfCars;
    private final NumberOfTrials numberOfTrials;

    public RacingCarInput(final NumberOfCars numberOfCars, final NumberOfTrials numberOfTrials) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrials = numberOfTrials;
    }

    public NumberOfCars getNumberOfCars() {
        return numberOfCars;
    }

    public NumberOfTrials getNumberOfTrials() {
        return numberOfTrials;
    }
}
