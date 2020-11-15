package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final static int DEFAULT_POSITION = 0;
    private final List<Car> cars;

    public RacingCars(final List<Car> racingCarList) {
        this.cars = racingCarList;
    }

    public void race() {
        for (Car car : this.cars) {
            car.move(new RandomStrategy());
        }
    }

    public int findMaxPosition() {
        int maxPosition = DEFAULT_POSITION;
        for (Car car : this.cars) {
            maxPosition = car.greaterThan(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> findWinners() {
        return findDuplicatePositionCar(this.findMaxPosition());
    }

    private List<Car> findDuplicatePositionCar(int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
