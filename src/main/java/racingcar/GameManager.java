package racingcar;

import racingcar.domain.RacingGame;
import racingcar.dto.Round;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class GameManager {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.inputCarCount();
        int roundCount = inputView.inputRoundCount();

        RacingGame game = new RacingGame(carCount, roundCount);
        List<Round> rounds = game.runGame(new RandomMoveStrategy());
        ResultView resultView = new ResultView(rounds);
        ResultView.printResultMessage();
        resultView.printGameResult();
    }
}
