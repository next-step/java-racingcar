package racinggame;

import racinggame.car.RandomMovableStrategy;
import racinggame.game.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.enterCarNames();
        int round = InputView.enterRound();

        RacingGame racingGame = new RacingGame(carNames, new RandomMovableStrategy());

        ResultView.showTitle();

        for (int i = 0; i < round; i++) {
            ResultView.showCarPositions(racingGame.start());
        }

        ResultView.showWinnerMessage(racingGame.getWinnerCarNames());
    }
}
