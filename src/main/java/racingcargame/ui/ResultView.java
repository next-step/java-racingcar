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

import racingcargame.domain.RacingCar;

public class ResultView extends AbstractView {
    private final String resultMessage = "실행 결과";

    public void printResultMessage() {
        print(resultMessage);
    }

    public void printCurrentStateOfRacingCar(RacingCar racingCar) {
        print(racingCar.getCurrentState());
    }
}
