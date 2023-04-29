package racing;

import racing.view.InputView;
import racing.view.OutputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputNames());
        int round = InputView.inputRound();
        RacingGame racingGame = new RacingGame(cars);
        OutputView.basicOutput();
        for (int i = 0; i < round; i++) {
            OutputView.outputProgress(racingGame.startGame(new RandomMove()));
        }
        OutputView.outputWinner(racingGame.getWinner());
    }

}
