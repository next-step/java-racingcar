package racing;

import racing.domain.RacingGame;
import racing.domain.RandomPowerGenerator;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        String carNames = InputView.carNames();
        int repeatCount = InputView.repeatCount();

        RacingGame racingGame = new RacingGame(carNames, repeatCount, new RandomPowerGenerator());
        Results results = racingGame.play();

        OutputView.printResults(results);
    }
}
