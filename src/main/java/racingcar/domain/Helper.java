package racingcar.domain;

import java.util.List;
import racingcar.common.UserInput;

public class Helper {

    public void runner(final List<String> input, final Racing racing) {

        for (String carName : input) {
            racing.registerCar(Car.of(carName));
        }
    }
}
