package racing.domain;

import racing.domain.enums.MoveStatus;
import racing.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int MAX_MOVABLE_RANGE = 9;

    private final List<Car> cars = new ArrayList<>();

    public static RacingCars create(List<Car> cars) {
        RacingCars racingCars = new RacingCars();
        racingCars.cars.addAll(cars);
        return racingCars;
    }

    public void moveCars() {
        for (Car car : this.cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (isMovable()) {
            car.go();
        }
    }

    private boolean isMovable() {
        return MoveStatus.GO == MoveStatus.findByNumber(NumberUtil.generateRandomNumberFromZeroToInputNumber(MAX_MOVABLE_RANGE));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getFarthestPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinnerCars() {
        int farthestPosition = getFarthestPosition();
        return this.cars.stream()
                .filter(car -> farthestPosition == car.getPosition())
                .collect(Collectors.toList());
    }
}
