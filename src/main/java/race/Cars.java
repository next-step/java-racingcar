package race;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNameList, MoveStrategy moveStrategy) {
        this.cars = carNameList.stream()
                .map(it -> new Car(it, moveStrategy))
                .collect(Collectors.toList());
    }

    public void moveAll() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public Position getFarthestPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position.getComparator())
                .get();
    }

    public List<Car> getFarthestCars() {
        return cars.stream()
                .filter(it -> it.getPosition().equals(getFarthestPosition()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return List.copyOf(cars);
    }
}
