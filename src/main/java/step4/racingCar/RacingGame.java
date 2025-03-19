package step4.racingCar;

import step4.racingCar.domain.Cars;
import step4.racingCar.view.InputView;
import step4.racingCar.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    public void race() {
        List<String> names = Arrays.asList(InputView.nameOfCars());
        int times = InputView.times();

        Cars cars = Cars.generateCars(names);

        ResultView.output();
        for (int i = 0; i < times; i++) {
            cars.move();
            ResultView.position(cars);
        }
        ResultView.result(cars.winners());
    }
}


