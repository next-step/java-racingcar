package racingcar;

import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class CarManager {

    public static Cars initCars(int carCount) {
        return Cars.create(carCount);
    }

    public static void move(Cars cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars = cars.move();
            ResultView.printHyphens(cars.getPositions());
        }
    }
}
