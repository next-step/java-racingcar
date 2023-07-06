package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public int maxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.INIT_POSITION);
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public List<CarStatus> mapToStatus() {
        return carList.stream()
                .map(CarStatus::new)
                .collect(Collectors.toList());
    }

    public List<CarName> findWinnerNames() {
        return carList.stream()
                .filter(car -> car.isWinner(maxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
