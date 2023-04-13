package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> createCars(String[] namesForCars, int numbersOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numbersOfCar; i++) {
            cars.add(new Car(namesForCars[i]));
        }
        return cars;
    }

    public void makeCarsMove() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).attemptMove(isMoved());
        }
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
        int farthestDistance = 0;
        for (Car car : this.cars) {
            farthestDistance = Math.max(farthestDistance, car.getCarCurrentDistance());
        }
        return farthestDistance;
    }

    private List<Car> getCarsWithFarthestDistance(int farthestDistance) {
        return cars.stream()
                .filter(car -> car.getCarCurrentDistance() == farthestDistance)
                .collect(Collectors.toList());
    }
}
