package racing;

import racing.domain.model.Cars;
import racing.domain.model.RacingGame;
import racing.domain.move.RandomMove;
import racing.view.InputView;
import racing.view.OutputView;

public class CarRacingApplication {

    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputNames());
        RacingGame racingGame = new RacingGame(cars, InputView.inputRound());
        OutputView.basicOutput();
        while (!racingGame.isOver()) {
            OutputView.outputProgress(racingGame.startGame(new RandomMove()));
        }
        OutputView.outputWinner(racingGame.getWinner());
    }

}
