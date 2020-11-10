package racingcar.application;

import racingcar.application.number.NumberGenerator;
import racingcar.domain.Car;

import java.util.List;


public class RacingSimulator {

    private NumberGenerator numberGenerator;

    public RacingSimulator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }
}
