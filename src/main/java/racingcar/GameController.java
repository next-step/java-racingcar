package racingcar;

import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;
import racingcar.domain.RacingGame;

public class GameController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingGame racingGame;

    GameController(InputView inputView, ResultView resultView, RacingGame racingGame) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingGame = racingGame;
    }

    public void run() {
        resultView.print(racingGame.start(inputView.read()));
    }
}
