package com.next.step.step3.view;

import com.next.step.step3.validate.InputValidation;

import java.util.Scanner;

public class InputView {

    private static final String NUM_OF_CARS_MESSAGE = "자동차 대수 몇 대 인가요?";

    private static final String NUM_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    private final InputValidation inputValidation;

    public InputView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
        this.scanner = new Scanner(System.in);
    }

    public int numOfCars() {
        System.out.println(NUM_OF_CARS_MESSAGE);
        int numOfCars = scanner.nextInt();
        inputValidation.validateNotNegative(numOfCars);
        inputValidation.validateNumOfCars(numOfCars);
        return numOfCars;
    }

    public int numOfAttempts() {
        System.out.println(NUM_OF_ATTEMPTS_MESSAGE);
        int numOfAttempts = scanner.nextInt();
        inputValidation.validateNotNegative(numOfAttempts);
        inputValidation.validateNumOfAttempts(numOfAttempts);
        return numOfAttempts;
    }
}
