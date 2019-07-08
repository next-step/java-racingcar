package racing;

import racing.model.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.getCarsByNames());

        int racingCount = InputView.getRacingCount();

        while (racingCount != 0) {
            racingGame.play();
            racingCount--;
        }

        OutputView.showResult(racingGame.getResult());
        OutputView.showWinner(racingGame.getCars());
    }
}
