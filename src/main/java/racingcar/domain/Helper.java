package racingcar.domain;

import racingcar.domain.movable.ForwardStrategy;

import java.util.List;

public class Helper {
    public void runner(final List<String> input, final Racing racing) {
        for (String carName : input) {
            racing.registerCar(Car.of(carName, new ForwardStrategy()));
        }
    }

}
