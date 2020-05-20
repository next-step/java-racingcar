/*
 * racinggame main class
 * 2020.05.14
 * version 1.0.0
 * 저작권 관련
 */
package edu.next.racing;

import edu.next.racing.model.RacingGame;
import edu.next.racing.ui.InputView;
import edu.next.racing.ui.ResultView;

/**
 * 자동차 경주 메인 클래스
 *
 * @version 1.0.0
 * @author GwangJunChoi
 */
public class RacingGameApp {

    /** 자동차 경주 메인 */
    public static void main(String[] args) {
        /** input ui */
        InputView inputView = new InputView();
        /** racingGame model */
        RacingGame racingGame = new RacingGame(inputView.displayCreateCarCountUi(),
                                                inputView.displayGameTimeInputUi());
        /** result ui */
        ResultView resultView = new ResultView(racingGame.execute(), racingGame.getTime());
        resultView.displayRacingResult();

    }

}
