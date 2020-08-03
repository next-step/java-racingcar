package racingcar.ui;

import racingcar.RacingData;
import resource.StringResources;

public abstract class RacingDataInput {

    public final RacingData getRacingData() {

        System.out.println(StringResources.ASK_NUMBER_OF_CARS);
        int numberOfCars = inputNumberOfCars();

        System.out.println(StringResources.ASK_TRY_COUNT);
        int tryCount = inputTryCount();

        return new RacingData(numberOfCars, tryCount);
    }

    abstract int inputNumberOfCars();
    abstract int inputTryCount();
}
