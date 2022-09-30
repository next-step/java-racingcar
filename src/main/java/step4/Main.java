package step4;

import step4.domain.RacingRecords;
import step4.domain.RacingGame;
import step4.domain.RacingGameHandler;
import step4.strategy.RandomMoveStrategy;
import step4.view.InputView;
import step4.view.ResultView;

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
