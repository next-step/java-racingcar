package carRacing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public void move(CarMovingStrategy strategy) {
        for (Car car : cars) {
            car.go(strategy);
            ResultView.printPosition(car);
        }
    }

    public Winners getWinners() {
        return new Winners(
                cars.stream()
                        .filter((Car car) -> car.isEqualPosition(getMaxPosition()))
                        .collect(Collectors.toList())
        );
    }
}
