package racingcar.domain.input;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputCarCount {

    private CarCount carCount;

    public InputCarCount(String value) {
        this.carCount = new CarCount(value);
    }

    public List<Car> toCars() {
        return carCount.getCarNames()
                .stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
