package controller;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.RandomUtils;
import utils.StringUtils;
import view.ResultView;

public class RacingGame {

    private final Cars cars;
    private final RandomUtils randomUtils;
    private final int MAX_RANDOM_NUMBER = 10;

    public RacingGame(String carNames) {
        this.cars = createCars(carNames);
        this.randomUtils = new RandomUtils(new Random());
    }

    public void play(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.play(rollDiceForAllCars());
            printCurrentPosition();
        }
    }

    private void printCurrentPosition() {
        for (Car car : cars.getCars()) {
            printPosition(car);
            System.out.println();
        }
    }

    private void printPosition(Car car) {
        System.out.print(!StringUtils.isEmpty(car.name()) ? car.name() + " : " : "");
        System.out.print("-".repeat(car.currentPosition()));
    }

    private List<Integer> rollDiceForAllCars() {
        int carCont = cars.carCount();
        List<Integer> results = new ArrayList<>(carCont);
        for (int i = 0; i < carCont; i++) {
            results.add(randomUtils.getRandomNumber(MAX_RANDOM_NUMBER));
        }
        return results;
    }

    protected Cars createCars(String carNames) {
        List<Car> cars = prepareCars(carNames);
        return new Cars(cars);
    }

    private List<Car> prepareCars(String carNames) {
        String[] names = carNames(carNames);
        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private String[] carNames(String carNames) {
        return carNames.split(",");
    }


    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            addWinner(winners, car, maxPosition);
        }
        return winners;
    }

    public Cars participatedCars() {
        return cars;
    }

    private void addWinner(List<String> winners, Car car, int maxPosition) {
        if (car.currentPosition() == maxPosition) {
            winners.add(car.name());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.currentPosition());
        }
        return maxPosition;
    }
}
