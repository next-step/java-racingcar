package step4;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public Cars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public void moveAll() {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<CarStatus> currentStatus() {
        return this.cars.stream()
                .map(Car::toCarStatus)
                .collect(toList());
    }

    public List<CarStatus> getWinnerStatus() {
        return getWinners().stream().map(Car::toCarStatus).collect(toList());
    }

    public List<Car> getWinners() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("There is no Car");
        }

        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("There is no Car"));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(toList());
    }
}
