package racingcar.model.domain;

import java.util.List;
import racingcar.model.entity.Car;

public class Helper {

    public void run(final List<String> input, final Racing racing) {

        for (String carName : input) {
            racing.registerCar(Car.of(carName));
        }
    }
}

