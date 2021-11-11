/*
 * ResultView
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame.ui;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentStateOfRacingCar(String state) {
        System.out.println(state);
    }

}
