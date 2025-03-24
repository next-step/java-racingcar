package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.NumberUtils;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        int carCount = NumberUtils.toInt(InputView.getCarCount());
        int tryCount = NumberUtils.toInt(InputView.getTryCount());

        Cars cars = CarManager.initCars(carCount);

        ResultView.printInitialState();
        ResultView.printHyphens(cars.getPositions());

        CarManager.move(cars, tryCount);
    }
}
