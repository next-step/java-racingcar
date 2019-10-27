package com.seok.racing;

import java.util.Scanner;

public class RacingGameInputView {

    private static final String NUMBER_OF_CARS_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_ATTEMPTS_MSG = "시도할 횟수는 몇 회 인가요 ?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberOfCars() {
        System.out.println(NUMBER_OF_CARS_MSG);
        return scanner.nextInt();
    }

    public static int getNumberOfAttempts() {
        System.out.println(NUMBER_OF_ATTEMPTS_MSG);
        return scanner.nextInt();
    }

}
