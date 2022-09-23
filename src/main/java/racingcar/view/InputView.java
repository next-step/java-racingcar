package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?\n";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";

    private InputView() {
    }

    public static String inputCarNames() {
        return input(INPUT_CAR_NAMES_MESSAGE);
    }

    public static String inputTryCount() {
        return input(INPUT_TRY_COUNT_MESSAGE);
    }

    public static String input(String inputMessage) {
        System.out.print(inputMessage);

        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
