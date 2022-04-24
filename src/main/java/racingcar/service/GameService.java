package racingcar.service;

import racingcar.model.PlayCount;
import racingcar.view.ResultView;
import racingcar.model.Cars;

public class GameService {
    public static void start(Cars cars, PlayCount playCount) {
        int index = 0;
        ResultView.printStartResult();

        while ( !playCount.isLast(index) ) {
            cars.play();
            cars.appendCarsStatus();
            index++;
        }
        ResultView.printCars(cars);

    }

}
