package edu.nextstep.camp.carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<Car> cars = initializeCars(carNames);

        int tryCount = getTryCount(scanner);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            ResultView.printCarStatus(cars);
        }
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
}