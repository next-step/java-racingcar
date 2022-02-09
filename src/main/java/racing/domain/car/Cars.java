package racing.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.domain.startegy.MovingStrategy;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        validateCars(cars);
        for (Car car : cars) {
            this.cars.add(new Car(car));
        }
    }

    private void validateCars(List<Car> cars) {
        validateZeroCar(cars);
        validateSameNameCars(cars);
    }

    private void validateSameNameCars(List<Car> cars) {
        final long distinctCarsSize = cars.stream()
            .map(Car::getNameValue)
            .distinct()
            .count();
        if (cars.size() != distinctCarsSize) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 들어갈 수 없습니다.");
        }
    }

    private void validateZeroCar(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 개수는 적어도 1개 이상이어야 합니다.");
        }
    }

    public List<Car> driveCars(MovingStrategy movingStrategy) {
        final List<Car> carsState = new ArrayList<>();
        for (Car car : cars) {
            car.drive(movingStrategy.moving());
            carsState.add(new Car(car));
        }
        return carsState;
    }

    private Position findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPositionValue());
        }
        return new Position(maxPosition);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> decideWinners() {
        final Position maxPosition = findMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }
}
