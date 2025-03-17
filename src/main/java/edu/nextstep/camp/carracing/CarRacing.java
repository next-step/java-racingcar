package edu.nextstep.camp.carracing;

import java.util.ArrayList;
import java.util.List;

import static edu.nextstep.camp.carracing.CarValidator.checkForDuplicateCarNames;
import static edu.nextstep.camp.carracing.InputView.getTryCount;
import static edu.nextstep.camp.carracing.InputView.inputCarNames;
import static edu.nextstep.camp.carracing.RandomNumberGenerator.generateRandomNumber;
import static edu.nextstep.camp.carracing.Winners.getWinners;

public class CarRacing {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void main(String[] args) {
        racing();
    }

    public static void racing() {
        List<String> carNames = inputCarNames();
        checkForDuplicateCarNames(carNames);
        List<Car> cars = initializeCars(carNames);

        int tryCount = getTryCount();

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            ResultView.printCarStatus(cars);
        }

        getWinners(cars);
    }

    private static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber(RANDOM_NUMBER_BOUND);
            car.move(randomNumber);
        }
    }
}