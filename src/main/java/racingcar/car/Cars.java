package racingcar.car;

import racingcar.engine.PowerEngine;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    private Cars(CarNames carNames, PowerEngine powerEngine) {
        this.cars = carNames.getNames()
                .stream()
                .map(name -> Car.newInstance(name, powerEngine))
                .collect(Collectors.toList());
    }

    public static Cars newInstance(CarNames carNames, PowerEngine powerEngine) {
        return new Cars(carNames, powerEngine);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move();
        }

        return getCars();
    }
}
