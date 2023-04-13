package domain;

import static domain.RandomNumber.generateRandomOutOfTen;
import static domain.RandomNumber.isOverFourOutOfTen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(UserInput userInput) {
        this.cars = createCars(userInput.getNamesForCars(), userInput.getNumbersOfCar());
    }

    private static List<Car> createCars(String[] namesForCars, int numbersOfCar) {
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
        List<Car> winners = checkCarWithFarthestDistance(this.cars);
        return winners.stream()
                .map(Car::getCarName)
                .toArray(String[]::new);
    }

    private static List<Car> checkCarWithFarthestDistance(List<Car> cars) {
        int farthestDistance = getFarthestDistance(cars);
        return getCarsWithFarthestDistance(farthestDistance, cars);
    }

    private static int getFarthestDistance(List<Car> cars) {
        int farthestDistance = 0;
        for (Car car : cars) {
            farthestDistance = Math.max(farthestDistance, car.getCarCurrentDistance());
        }
        return farthestDistance;
    }

    private static List<Car> getCarsWithFarthestDistance(int farthestDistance, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.getCarCurrentDistance() == farthestDistance)
                .collect(Collectors.toList());
    }
}
