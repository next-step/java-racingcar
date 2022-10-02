package com.game.racing.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_MESSAGE_OF_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    public static final Integer MAX_LENGTH_OF_CAR_NAME = 5;
    private static final String CAR_NAMES_SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("InputView 클래스는 인스턴스화할 수 없습니다!");
    }

    public static String[] inputCarNames() {
        String inputString = inputStringByScanner(INPUT_MESSAGE_OF_CAR_NAMES);
        String[] splitCarNames = inputString.split(CAR_NAMES_SEPARATOR);
        for (String carName : splitCarNames) {
            validateCarName(carName);
        }
        return splitCarNames;
    }

    private static void validateCarName(String carName) {
        if (carName.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다!");
        }
    }

    public static int inputTryCount() {
        return inputNumberByScanner(INPUT_MESSAGE_OF_TRY_COUNT);
    }

    public static int inputNumberByScanner(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String inputStringByScanner(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
