package com.sryoondev.racingcar.step3.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_QUESTION_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String CAR_NAMES_QUESTION_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static Scanner getUserInput() {
        return new Scanner(System.in);
    }

    public static String[] getCarNames() {
        System.out.println(CAR_NAMES_QUESTION_MESSAGE);
        return getUserInput().next().split(",");
    }

    public static int getCarCount() {
        System.out.println(CAR_COUNT_QUESTION_MESSAGE);
        return getUserInput().nextInt();
    }

    public static int getTryCount() {
        System.out.println(TRY_COUNT_QUESTION_MESSAGE);
        return getUserInput().nextInt();
    }
}
