package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("차는 1대 이상이어야 합니다");
        }
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void drive(DrivingStrategy drivingStrategy) {
        for (Car car : cars) {
            car.drive(drivingStrategy);
        }
    }

    public List<Integer> drivingDistances() {
        return cars.stream()
            .map(Car::drivingDistance)
            .collect(Collectors.toList());
    }

    public String getResult() {
        return cars.stream()
            .map(Car::getResult)
            .collect(Collectors.joining("\n"));
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
            .filter(car -> car.matchDistance(maxDistance))
            .collect(Collectors.toList());

    }

    private int getMaxDistance() {
        return cars.stream()
            .mapToInt(Car::drivingDistance)
            .max()
            .orElseThrow(IllegalStateException::new);
    }
}
