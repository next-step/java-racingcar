package step5;

import step5.domain.RacingGame;
import step5.domain.RacingGameHandler;
import step5.domain.RacingRecords;
import step5.strategy.RandomMoveStrategy;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        RacingGameHandler racingGameHandler = new RacingGameHandler(racingGame, new RandomMoveStrategy());

        racingGameHandler.playWithMoveStrategy();

        List<RacingRecords> racingRecords = racingGameHandler.getRacingRecords();
        ResultView.showRecords(racingRecords);

        List<String> winners = racingGameHandler.winners();
        ResultView.infoWinners(winners);
    }
}
