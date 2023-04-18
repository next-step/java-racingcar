package racing;

import racing.view.InputView;
import racing.view.OutputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputCarCount());
        RacingGame racingGame = new RacingGame(InputView.inputTryCount(), cars);
        OutputView.basicOutput();
        OutputView.outputProgress(racingGame.startGame(new RandomMove()));
        OutputView.outputWinner(racingGame.getWinner());
    }

}
