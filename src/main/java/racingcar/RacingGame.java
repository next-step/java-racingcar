package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int gameRoundNum = InputView.getGameRoundNum();

        GameManager gameManager = new GameManager(new RuleStrategyImpl());
        Records records = gameManager.play(carNames, gameRoundNum);

        OutputView.showResult(records);
    }
}
