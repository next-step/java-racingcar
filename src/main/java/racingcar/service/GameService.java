package racingcar.service;

import racingcar.view.ResultView;
import racingcar.model.Cars;

public class GameService {
    public static void start(Cars cars, int playCount) {
        int startCount = 0;

        ResultView.printStartResult();
        while ( startCount != playCount) {
            cars.play();
            ResultView.printCars(cars);
            System.out.println("\n");
            startCount++;
        }
    }
}
