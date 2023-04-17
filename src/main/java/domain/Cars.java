package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static List<Car> createCars(String[] namesForCars, int numbersOfCar) {
        return IntStream.range(0, numbersOfCar)
                .mapToObj(i -> new Car(namesForCars[i]))
                .collect(Collectors.toList());
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


    public String[] getWinnerNames() {
        List<Car> winners = checkCarWithFarthestDistance();
        return winners.stream()
                .map(Car::getCarName)
                .toArray(String[]::new);
    }

    private List<Car> checkCarWithFarthestDistance() {
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
