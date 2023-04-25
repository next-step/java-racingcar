package racing_mvc.controller;

import racing_mvc.domain.Racing;
import racing_mvc.view.InputView;
import racing_mvc.view.ResultView;

public class RacingGameController {

    public void start() {
        InputView inputView = InputView.create();
        String carNames = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        ResultView.start();
        Racing racing = new Racing(carNames,tryCount);

        for (int i = 0; i < tryCount; i++) {
            ResultView.showRace(racing.race());
        }
        ResultView.showWinners(racing.winner());
    }
}
