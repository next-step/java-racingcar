package edu.nextstep.camp.racingcar.step3;

import java.util.Scanner;

public class CarRacing {
    private static final String QUESTION_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_HOW_MANY_TRIES = "시도할 회수는 몇 회 인가요?";

    public static void process() {
        Scanner scanner = new Scanner(System.in);
        int getCarCount = getCarCount(scanner);
        int getTryCount = getTryCount(scanner);
    }

    protected static int getCarCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_CARS);
        return scanner.nextInt();
    }

    protected static int getTryCount(Scanner scanner) {
        System.out.println(QUESTION_HOW_MANY_TRIES);
        return scanner.nextInt();
    }
}