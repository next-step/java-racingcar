package racingcar.view;

import racingcar.util.InputViewUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?\n";
    private static final String INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?\n";

    private InputView() {
    }

    public static String inputNumberOfCars() {
        return input(INPUT_NUMBER_OF_CARS_MESSAGE);
    }

    public static String inputTryCount() {
        return input(INPUT_TRY_COUNT_MESSAGE);
    }

    public static String input(String inputMessage) {
        System.out.print(inputMessage);

        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
