package racingcar.ui;

import racingcar.domain.RacingData;
import resource.StringResources;

public abstract class RacingDataInput {

    public final RacingData getRacingData() {

        System.out.println(StringResources.INPUT_CAR_NAME);
        String names = inputNames();

        System.out.println(StringResources.ASK_NUMBER_OF_CARS);
        int numberOfCars = inputNumberOfCars();

        System.out.println(StringResources.ASK_TRY_COUNT);
        int tryCount = inputTryCount();

        return new RacingData(names, numberOfCars, tryCount);
    }

    public abstract String inputNames();
    public abstract int inputNumberOfCars();
    public abstract int inputTryCount();
}
