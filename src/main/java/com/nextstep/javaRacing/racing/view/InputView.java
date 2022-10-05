package com.nextstep.javaRacing.racing.view;

import java.util.Scanner;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TURNS_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int scanTurns() {
        System.out.println(TURNS_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
