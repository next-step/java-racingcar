package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {

    private Racing() {
    }

    public static Racing instance() {
        return new Racing();
    }

    public void drive(final List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(idx -> cars.get(idx).moveForward());
    }

}
