package carracingfield;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import random.RandomGenerator;
import winnerstrategy.WinnerStrategy;

public class CarRacingField {

    private List<Car> cars = new ArrayList<>();
    private WinnerStrategy winnerStrategy;

    public CarRacingField(List<String> carNames, WinnerStrategy winnerStrategy) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.winnerStrategy = winnerStrategy;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCarsByCount(int count) {
        for (int i = 0; i < count; i++) {
            moveCarsSingleTime();
            printCurrentCarStatus();
            System.out.println();
        }
    }

    private void printCurrentCarStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private void moveCarsSingleTime() {
        for (Car car : cars) {
            car.moveOrStopByRandomValue(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public List<Car> getWinners() {
        return winnerStrategy.getWinners(cars);
    }
}
