package step4.racing.domain;

import step4.racing.ui.InputView;
import step4.racing.ui.ResultView;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingInfo racingInfo = inputView.inputStart();
        RacingGame racingGame = new RacingGame(racingInfo);
        racingGame.settingCars();
        ResultView resultView = new ResultView(racingGame, racingInfo);
        resultView.view();
    }
}
