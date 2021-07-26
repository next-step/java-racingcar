package edu.nextstep.racingcar.step3.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private int numberOfCars;
    private int numberOfAttempts;

    public InputView() {
        input();
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(QUESTION_NUMBER_OF_CARS);
        numberOfCars = scanner.nextInt();

        System.out.println(QUESTION_NUMBER_OF_ATTEMPTS);
        numberOfAttempts = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
