package racingcar;

import java.util.stream.IntStream;

import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class CarManager {

    public static Cars initCars(int carCount) {
        return Cars.create(carCount);
    }

    public static void move(Cars cars, int tryCount) {
        IntStream.range(0, tryCount)
            .forEach(count -> move(cars));
    }

    private static void move(Cars cars) {
        cars.move();
        ResultView.printHyphens(cars.getPositions());
    }
}
