package game.domain;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Cars {

    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = initialCars(carNames);
    }

    private List<Car> initialCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(toUnmodifiableList());
    }

    public void drive() {
        carList.forEach(Car::drive);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> findWinners() {
        return carList.stream()
                .filter(car -> car.isSamePosition(getMaxPosition()))
                .collect(toUnmodifiableList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::position)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

}