package racingcar.domain;

import java.util.Collections;
import racingcar.domain.movable.MovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    private Cars(final List<String> input, final MovableStrategy strategy) {
        for (String carName : input) {
            cars.add(Car.of(carName, strategy));
        }
    }

    public static Cars of(final List<String> input, final MovableStrategy strategy) {
        return new Cars(input, strategy);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
