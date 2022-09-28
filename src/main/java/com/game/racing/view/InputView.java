package com.game.racing.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_MESSAGE_OF_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_MESSAGE_OF_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new IllegalStateException("InputView 클래스는 인스턴스화할 수 없습니다!");
    }

    public static String inputCarNames() {
        return inputStringByScanner(INPUT_MESSAGE_OF_CAR_NAMES);
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
