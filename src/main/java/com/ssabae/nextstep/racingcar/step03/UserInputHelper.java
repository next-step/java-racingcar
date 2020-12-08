package com.ssabae.nextstep.racingcar.step03;

import java.util.Scanner;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class UserInputHelper {

    private static final String CAR_NAMES_INPUT_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String INVALID_INPUT_TEXT = "입력값은 숫자만 허용됩니다. 다시 입력 바랍니다.";

    public int inputTryCount() {
        return inputNextInt(TRY_COUNT_INPUT_TEXT);
    }

    public String inputCarNames() {
        return inputNextLine(CAR_NAMES_INPUT_TEXT);
    }

    private String inputNextLine(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }

    private int inputNextInt(String text) {
        String nextLine = inputNextLine(text);
        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException exception) {
            System.out.println(INVALID_INPUT_TEXT);
            return inputNextInt(text);
        }
    }
}
