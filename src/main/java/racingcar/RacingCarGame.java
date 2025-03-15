package racingcar;

import racingcar.view.InputView;

public class RacingCarGame {

    public static final String INVALID_INPUT_MSG = "invalid input ";

    public static void main(String[] args) {

        int carCount = InputView.showCarCountInput();
        if(!isPositiveNumber(carCount)) {
            System.out.println(INVALID_INPUT_MSG+carCount);
            return;
        }

        int tryCount = InputView.showTryCountInput();
        if(!isPositiveNumber(tryCount)) {
            System.out.println(INVALID_INPUT_MSG+tryCount);
            return;
        }
    }

    private static Boolean isPositiveNumber(int number) {
        return number > 0;
    }
}