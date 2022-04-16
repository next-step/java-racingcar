package racingcar.service;

import racingcar.view.ResultView;
import racingcar.model.Cars;

public class GameService {
    public static void start(Cars cars, int playCount) {
        int startCount = 0;

        ResultView.printStartResult();
        while ( startCount != playCount ) {
            cars.play();
            cars.appendCarsStatus();
            startCount++;
        }
        ResultView.printCars(cars);

    }
}
