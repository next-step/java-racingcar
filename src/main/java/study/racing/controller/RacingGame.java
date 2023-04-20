package study.racing.controller;

import study.racing.domain.Car;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final Random random;
    private final InputView inputView;
    private final ResultView resultView;

    public RacingGame() {
        random = new Random();
        inputView = InputView.getInstance();
        resultView = ResultView.getInstance();
    }

    public List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveOrStop(car);
        }
        return cars;
    }

    public Car moveOrStop(Car car) {
        int randomInt = random.nextInt(10);
        if (car.canMove(randomInt)) {
            car.moveForward();
            return car;
        }
        return car;
    }

    // 우승한 자동차 조회
    public List<Car> getWinningCars(List<Car> cars) {
        int longestDistance = getLongestDistance(cars);
        List<Car> winningCars = new ArrayList<>();
        for (Car car : cars) {
            getCarsWithLocation(longestDistance, winningCars, car);
        }
        return winningCars;
    }

    public void getCarsWithLocation(int location, List<Car> cars, Car car) {
        if (car.getCurrentLocation() == location) {
            cars.add(car);
        }
    }

    public int getLongestDistance(List<Car> cars) {
        int longestDistance = 0;
        for (Car car : cars) {
            longestDistance = Math.max(longestDistance, car.getCurrentLocation());
        }
        return longestDistance;
    }

    public void displayCars(List<Car> cars) {
        System.out.println(resultView.getStatusCars(cars));
    }

    public List<Car> carSetting() {
        return inputView.readCars(inputView.readCarNames());
    }

    public int getTrial() {
        return inputView.readTrialNumber();
    }

    public void start() {
        System.out.println("실행 결과");
    }

    public void end(List<Car> cars) {
        List<Car> winningCars = getWinningCars(cars);
        System.out.println(resultView.displayWinningCars(winningCars));
    }
}
