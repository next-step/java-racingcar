package racingcar;

import racingcar.application.RacingGameManager;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameRepository;
import racingcar.domain.RacingGameResults;
import racingcar.infrastructure.InMemoryRacingGameRepository;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingGameApplication {


    public static void main(String[] args) {
        RacingGameRepository racingGameRepository = new InMemoryRacingGameRepository();
        RacingGameManager racingGameManager = new RacingGameManager(racingGameRepository);

        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.getCarNames(), inputView.getTime());
        RacingGameResults gameResults = racingGameManager.game(racingGame);

        ResultView resultView = new ResultView();
        resultView.print(gameResults);
    }

}
