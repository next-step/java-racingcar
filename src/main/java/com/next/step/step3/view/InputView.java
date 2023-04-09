package com.next.step.step3.view;

import java.util.Scanner;

public class InputView {

    private static final String NUM_OF_CARS_MESSAGE = "자동차 대수 몇 대 인가요?";

    private static final String NUM_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int numOfCars() {
        System.out.println(NUM_OF_CARS_MESSAGE);
        return scanner.nextInt();
    }

    public int numOfAttempts() {
        System.out.println(NUM_OF_ATTEMPTS_MESSAGE);
        return scanner.nextInt();
    }
}
