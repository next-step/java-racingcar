package racingcar.controller;

import racingcar.domain.Car;
import racingcar.generator.NumberGenerator;
import racingcar.view.ResultView;

public class CarController {
    public static String move(Car car, NumberGenerator numberGenerator) {
        car.move(numberGenerator);
        return ResultView.printMovement(car.getMovementCount());
    }
}
