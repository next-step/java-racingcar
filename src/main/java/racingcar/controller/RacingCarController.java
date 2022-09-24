package racingcar.controller;

import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.RacingGameResult;
import racingcar.service.RacingRequest;
import racingcar.view.ResultView;

public class RacingCarController {
    private final RacingGame racingGame = new RacingGame(new RacingCarRepository());

    public void run() {
        RacingRequest request = InputView.input();

        RacingGameResult result = racingGame.start(request);

        ResultView.printResult(result);
    }
}
