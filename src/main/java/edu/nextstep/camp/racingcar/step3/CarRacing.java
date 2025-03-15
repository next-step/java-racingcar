package edu.nextstep.camp.racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static edu.nextstep.camp.racingcar.step3.InputView.getCarCount;
import static edu.nextstep.camp.racingcar.step3.InputView.getTryCount;

public class CarRacing {
    private static final Random random = new Random();

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void racing() {
        Scanner scanner = new Scanner(System.in);
        int carCount = getCarCount(scanner);
        int tryCount = getTryCount(scanner);

        process(carCount, tryCount);

        ResultView.printResult(List.of("---", "-", "--"));
    }

    private static void process(int carCount, int tryCount) {
        List<String> cars = initializeList(carCount);
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, carCount);
        }
    }

    private static List<String> initializeList(int carCount) {
        List<String> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add("");
        }
        return cars;
    }

    private static void moveCars(List<String> cars, int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.set(i, cars.get(i) + moveOrStay(getRandomNumber()));
        }
    }

    protected static String moveOrStay(int number) {
        if (number >= 4) {
            return "-";
        }
        return "";
    }

    private static int getRandomNumber() {
        return random.nextInt(10);
    }
}