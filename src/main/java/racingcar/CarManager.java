package racingcar;

import racingcar.domain.Cars;

public class CarManager {

    public static Cars initCars(int carCount) {
        return Cars.create(carCount);
    }
}
