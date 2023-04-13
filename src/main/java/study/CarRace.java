package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;

public class CarRace {
    private static final Random random = new Random();

    public static List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveOrStop(car);
        }
        return cars;
    }

    public static Car moveOrStop(Car car) {
        int randomInt = random.nextInt(10);
        if (car.canMove(randomInt)) {
            car.moveForward();
            return car;
        }
        return car;
    }

    // 우승한 자동차 조회
    public static List<Car> getWinningCars(List<Car> cars) {
        int longestDistance = getLongestDistance(cars);
        List<Car> winningCars = new ArrayList<>();
        for (Car car : cars) {
            getCarsWithLocation(longestDistance, winningCars, car);
        }
        return winningCars;
    }

    public static void getCarsWithLocation(int location, List<Car> cars, Car car) {
        if (car.getCurrentLocation() == location) {
            cars.add(car);
        }
    }

    public static int getLongestDistance(List<Car> cars) {
        int longestDistance = 0;
        for (Car car : cars) {
            longestDistance = Math.max(longestDistance, car.getCurrentLocation());
        }
        return longestDistance;
    }

    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        List<Car> cars = InputView.readCars(carNames);
        int trialNumber = InputView.readTrialNumber();

        out.println("실행 결과");

        for (int i = 0; i < trialNumber; i++) {
            out.println(ResultView.getStatusCars(cars));
            moveCars(cars);
        }

        out.println(ResultView.getStatusCars(cars));
        List<Car> winningCars = getWinningCars(cars);
        out.println(ResultView.displayWinningCars(winningCars));
    }
}
