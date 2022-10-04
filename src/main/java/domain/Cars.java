package domain;

import static java.lang.Math.max;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = createInitCarList(carNames);
    }

    public List<Car> createInitCarList(List<String> carNames) {
        return carNames.stream()
            .map(Car::createCarWithName)
            .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        int maxDist = findMaxDistance();
        return cars.stream()
            .filter(car -> isSameDistance(car, maxDist))
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        int maxDist = 0;
        for (Car car : cars) {
            maxDist = max(car.getCurrentLocation(), maxDist);
        }
        return maxDist;
    }

    private boolean isSameDistance(Car car, int maxDist) {
        return car.getCurrentLocation() == maxDist;
    }

    public List<Car> getCars() {
        return cars;
    }

}
