package racingcar;

import racingcar.domain.GameManager;
import racingcar.domain.GameResult;
import racingcar.domain.RuleStrategyImpl;
import racingcar.domain.WinStrategyImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        try {
            executeGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeGame() {
        List<String> carNames = InputView.getCarNames();
        int gameRoundNum = InputView.getGameRoundNum();

        GameManager gameManager = new GameManager(new RuleStrategyImpl(), new WinStrategyImpl());
        GameResult gameResult = gameManager.play(carNames, gameRoundNum);

        OutputView.showResult(gameResult);
    }
}
