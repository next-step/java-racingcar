package com.game.racing.view;

import java.util.Scanner;

public class InputView {

    private InputView() {
        throw new IllegalStateException("InputView 클래스는 인스턴스화할 수 없습니다!");
    }

    public static final String INPUT_MESSAGE_OF_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    public static final String INPUT_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static int inputCarCount() {
        return inputIntegerWithMessage(INPUT_MESSAGE_OF_CAR_COUNT);
    }

    public static int inputTryCount() {
        return inputIntegerWithMessage(INPUT_MESSAGE_OF_TRY_COUNT);
    }

    public static int inputIntegerWithMessage(String message) {
        System.out.println(message);
        return inputIntByScanner();
    }

    public static int inputIntByScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
