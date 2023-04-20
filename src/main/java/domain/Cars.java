package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String[] namesForCars) {
        return new Cars(Arrays.stream(namesForCars)
                        .map(Car::new)
                        .collect(Collectors.toList()));
    }

    public void makeCarsMove() {
        cars.stream()
                .forEach(car -> car.attemptMove(isMoved()));
    }

    private boolean isMoved() {
        return isOverFourOutOfTen(generateRandomOutOfTen());
    }

    public int countCars() {
        return cars.size();
    }

    public Car getEachCar(int carIndex) {
        return cars.get(carIndex);
    }

    public List<Car> checkCarWithFarthestDistance() {
        int farthestDistance = getFarthestDistance();
        return getCarsWithFarthestDistance(farthestDistance);
    }

    private int getFarthestDistance() {
        return cars.stream()
                .mapToInt(Car::getCarCurrentDistance)
                .max()
                .orElse(0);
    }

    private List<Car> getCarsWithFarthestDistance(int farthestDistance) {
        return cars.stream()
                .filter(car -> car.getCarCurrentDistance() == farthestDistance)
                .collect(Collectors.toList());
    }
}
