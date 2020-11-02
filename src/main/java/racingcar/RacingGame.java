package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int carNum = inputView.getCarNum();
        int gameRoundNum = inputView.getGameRoundNum();

        GameManager gameManager = new GameManager();
        List<Car> cars = gameManager.readyCars(carNum, new RuleStrategyImpl());
        GameRound gameRound = new GameRound(gameRoundNum);

        while (!gameRound.isGameEnd()) {
            gameManager.playOneRound(cars);
            outputView.showResult(cars);
            gameRound.endRound();
        }
    }
}
