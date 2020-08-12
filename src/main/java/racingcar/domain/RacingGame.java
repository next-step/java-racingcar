package racingcar.domain;

import java.util.stream.Collectors;

import static racingcar.domain.CarFactory.initCars;
import static racingcar.utils.RandomValueGenerator.randomForward;
import static racingcar.view.OutputView.printCarStatus;
import static racingcar.view.OutputView.resultView;

public class RacingGame {
    public static void racingStart(String carsName, int tryCount) {
        Cars cars = initCars(carsName);
        for(int i=0; i < tryCount; i++) {
            cars = moveCarForward(cars);
            printCarStatus(cars);
            System.out.println();
        }
        resultView(cars);
    }

    public static Cars moveCarForward(Cars cars) {
        return new Cars(cars.getCars().stream().peek(car -> car.move(randomForward())).collect(Collectors.toList()));
    }
}
