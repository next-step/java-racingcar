package edu.nextstep.camp.racingcar.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacing {
    private static final String QUESTION_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_HOW_MANY_TRIES = "시도할 회수는 몇 회 인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final Random random = new Random();

    private CarRacing() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static void racing() {
        Scanner scanner = new Scanner(System.in);
        int carCount = getCarCount(scanner);
        int tryCount = getTryCount(scanner);

        process(carCount, tryCount);
    }

    protected static int getCarCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_CARS);
        return scanner.nextInt();
    }

    protected static int getTryCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_TRIES);
        return scanner.nextInt();
    }

    protected static void process(int carCount, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        List<String> cars = initializeList(carCount);
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, carCount);
            print(cars);
        }
    }

    private static List<String> initializeList(int carCount) {
        List<String> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add("");
        }
        return cars;
    }

    protected static void moveCars(List<String> cars, int carCount) {
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

    private static void print(List<String> cars) {
        for (String car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}