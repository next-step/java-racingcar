package edu.nextstep.camp.racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.nextstep.camp.racingcar.step3.InputView.getCarCount;
import static edu.nextstep.camp.racingcar.step3.InputView.getTryCount;

public class CarRacing {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void racing() {
        Scanner scanner = new Scanner(System.in);
        int carCount = getCarCount(scanner);
        int tryCount = getTryCount(scanner);

        List<Car> cars = initializeCars(carCount);

        ResultView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, carCount);
            ResultView.printCarStatus(cars);
        }
    }

    private static List<Car> initializeCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private static void moveCars(List<Car> cars, int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.get(i).move(RandomNumberGenerator.generateRandomNumber(RANDOM_NUMBER_BOUND));
        }
    }
}