package com.sryoondev.racingcar.step3.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_COUNT_QUESTION_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static int getUserInput() {
        return new Scanner(System.in).nextInt();
    }

    public static int getCarCount() {
        System.out.println(CAR_COUNT_QUESTION_MESSAGE);
        return getUserInput();
    }

    public static int getTryCount() {
        System.out.println(TRY_COUNT_QUESTION_MESSAGE);
        return getUserInput();
    }
}
