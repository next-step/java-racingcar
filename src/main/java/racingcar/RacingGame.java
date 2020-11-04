package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int carNum = inputView.getCarNum();
        int gameRoundNum = inputView.getGameRoundNum();

        GameManager gameManager = new GameManager(new RuleStrategyImpl());
        Records records = gameManager.play(carNum, gameRoundNum);

        outputView.showResult(records);
    }
}
