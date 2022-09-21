package racingcar.view;

import racingcar.util.InputViewUtil;

public class InputView {

    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?\n";
    private static final String INPUT_NUMBER_OF_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?\n";

    public static String inputNumberOfCars() {
        return InputViewUtil.input(INPUT_NUMBER_OF_CARS_MESSAGE);
    }

    public static String inputTryCount() {
        return InputViewUtil.input(INPUT_TRY_COUNT_MESSAGE);
    }
}
