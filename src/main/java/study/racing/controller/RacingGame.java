package study.racing.controller;

import study.racing.domain.Car;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static RacingGame instance = null;

    private final Random random;
    private final InputView inputView;
    private final ResultView resultView;

    public static RacingGame getInstance() {
        if (instance == null) {
            instance = new RacingGame();
        }
        return instance;
    }

    private RacingGame() {
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

    public void play() {
        String carNames = inputView.readCarNames();
        List<Car> cars = inputView.readCars(carNames);
        int trial = inputView.readTrialNumber();

        System.out.println("실행 결과");

        for (int i = 0; i < trial; i++) {
            System.out.println(resultView.getStatusCars(cars));
            moveCars(cars);
        }

        System.out.println(resultView.getStatusCars(cars));
        List<Car> winningCars = getWinningCars(cars);
        System.out.println(resultView.displayWinningCars(winningCars));
    }
}
