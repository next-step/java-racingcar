package game.domain;

import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars of(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(toUnmodifiableList());
        return new Cars(cars);
    }

    public void drive() {
        carList.forEach(Car::drive);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> findWinners() {
        return carList.stream()
                .filter(car -> car.isWinner(getMaxPosition()))
                .collect(toUnmodifiableList());
    }

    private Position getMaxPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(naturalOrder())
                .orElseThrow(IllegalStateException::new);
    }

}