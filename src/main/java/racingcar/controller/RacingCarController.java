package racingcar.controller;

import racingcar.repository.RacingCarTable;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.RacingGameResult;
import racingcar.view.RacingRequest;
import racingcar.view.ResultView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame(new RacingCarTable());

    public void run() {
        RacingRequest request = InputView.input();

        RacingGameResult result = racingGame.start(request);

        ResultView.printResult(result);
    }
}
