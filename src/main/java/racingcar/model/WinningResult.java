package racingcar.model;

import java.util.List;

import static java.util.stream.Collectors.toList;
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
                .collect(toList());

        return new WinningResult(winningCars);
    }

    public List<String> getNames() {
        return cars.stream().map(Car::getName).collect(toList());
    }
}
