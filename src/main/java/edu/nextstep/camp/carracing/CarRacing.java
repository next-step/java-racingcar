package edu.nextstep.camp.carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.nextstep.camp.carracing.CarValidator.checkForDuplicateCarNames;
import static edu.nextstep.camp.carracing.InputView.getTryCount;
import static edu.nextstep.camp.carracing.InputView.inputCarNames;
import static edu.nextstep.camp.carracing.StringUtils.split;

public class CarRacing {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Scanner scanner = new Scanner(System.in);

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void main(String[] args) {
        racing();
    }

    public static void racing() {
        String[] carNames = split(inputCarNames(scanner));
        checkForDuplicateCarNames(carNames);
        List<Car> cars = initializeCars(carNames);

        int tryCount = getTryCount(scanner);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            ResultView.printCarStatus(cars);
        }

        selectWinners(cars);
    }

    private static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generateRandomNumber(RANDOM_NUMBER_BOUND));
        }
    }

    private static void selectWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getMaxPositionCars(cars, maxPosition);
        ResultView.printWinners(winners);
    }

    protected static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    protected static List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(maxPosition, winners, car);
        }
        return winners;
    }

    private static void addWinner(int maxPosition, List<String> winners, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}