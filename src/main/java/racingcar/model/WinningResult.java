package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.model.Car.DEFAULT_POSITION;

public class WinningResult {

    private List<Car> cars;

    private WinningResult(List<Car> cars) {
        this.cars = cars;
    }

    public static WinningResult of(Cars cars) {
        List<Car> carList = cars.getCars();

        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_POSITION);

        List<Car> winningCars = carList.stream()
                .filter(car -> car.isMatchPosition(maxPosition))
                .collect(Collectors.toList());

        return new WinningResult(winningCars);
    }

    public List<String> winners() {
        return cars.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
