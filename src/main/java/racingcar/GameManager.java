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
        List<String> carNames = inputView.inputCarNames();
        int roundCount = inputView.inputRoundCount();

        RacingGame game = new RacingGame(carNames, roundCount);
        List<Round> rounds = game.runGame(new RandomMoveStrategy());

        ResultView.printResultMessage();
        ResultView.printGameResult(rounds);
        ResultView.printGameWinners(game.winnersList());

    }
}
