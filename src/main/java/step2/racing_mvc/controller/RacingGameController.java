package step2.racing_mvc.controller;

import step2.racing_mvc.domain.RacingGame;
import step2.racing_mvc.view.InputView;
import step2.racing_mvc.view.ResultView;

public class RacingGameController {

    public void start() {
        InputView inputView = InputView.create();
        String carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        ResultView.start();
        RacingGame racing = new RacingGame(carNames,tryCount);

        for (int i = 0; i < tryCount; i++) {
            ResultView.showRace(racing.race());
        }
        ResultView.showWinners(racing.winner());
    }
}