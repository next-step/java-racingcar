package edu.nextstep.racingcar.step3;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        int numberOfAttempts = scanner.nextInt();

        System.out.println(String.format("%s, %s", numberOfCars, numberOfAttempts));
    }
}
