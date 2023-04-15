package com.next.step.step3.view;

import com.next.step.step3.validate.InputValidation;

import java.util.Scanner;

public class InputView {

    private static final String CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String NUM_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    private final InputValidation inputValidation;

    public InputView(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
        this.scanner = new Scanner(System.in);
    }

    public String carsName() {
        System.out.println(CARS_NAME_MESSAGE);

        String carNames = scanner.next();
        inputValidation.validateExistName(carNames);

        return carNames;
    }

    public int numOfAttempts() {
        System.out.println(NUM_OF_ATTEMPTS_MESSAGE);
        int numOfAttempts = scanner.nextInt();
        inputValidation.validateNotNegative(numOfAttempts);
        inputValidation.validateNumOfAttempts(numOfAttempts);
        return numOfAttempts;
    }
}
