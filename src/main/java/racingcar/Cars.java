package racingcar;

import racingcar.moving.MovingStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public static Cars of(final String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::of)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private Cars() {
    }

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    void moveCars(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    List<Car> getCars() {
        return this.cars;
    }

    List<Car> getWinnerCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .map(winnerCar -> cars.stream()
                        .filter(car -> car.isSamePosition(winnerCar.getPosition()))
                        .collect(Collectors.toList())
                ).orElseGet(ArrayList::new);
    }
}
