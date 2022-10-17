package domain;

import java.util.List;
import java.util.Objects;

public class Racing {

    private final Cars cars;

    public Racing(List<CarName> carNames) { cars = makeCar(carNames); }

    private Cars makeCar(List<CarName> carNames) {
        return new Cars(carNames);
    }

    public void race(MovingStrategy movingStrategy) {
        for (Car car : cars.getCars()) {
            car.move(movingStrategy.isMovable(movingStrategy.getIntValue()));
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
