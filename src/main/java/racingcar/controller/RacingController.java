package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.GameResult;
import racingcar.domain.RuleStrategyImpl;
import racingcar.domain.WinStrategyImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public static GameResult execute(List<String> carNames, int gameRoundNum) {
        GameManager gameManager = new GameManager(new RuleStrategyImpl(), new WinStrategyImpl());
        return gameManager.play(carNames, gameRoundNum);
    }

    public static void showResult(GameResult gameResult) {
        OutputView.showResult(gameResult);
    }

    public static List<String> getCarNames() {
        return InputView.getCarNames();
    }

    public static int getGameRoundNum() {
        return InputView.getGameRoundNum();
    }
}
