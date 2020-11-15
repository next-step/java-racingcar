package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public Cars createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Name name = new Name(carName);
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public Cars race(Cars cars, MovingStrategy movableGenerator) {
        for (Car car : cars.getValue()) {
            car.move(movableGenerator);
        }
        return cars;
    }

    public Cars getWinners(Cars cars) {

        int winnerPosition = cars.getValue().stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("The winner is not exists."));

        List<Car> carList = cars.getValue().stream()
                .filter(car -> car.isEqualPositionValue(winnerPosition))
                .collect(Collectors.toList());

        return new Cars(carList);
    }
}
