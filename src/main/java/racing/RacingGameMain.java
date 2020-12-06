package racing;

import racing.domain.RacingGame;
import racing.domain.RandomPowerGenerator;
import racing.view.InputView;

public class RacingGameMain {
    public static void main(String[] args) {
        String carNames = InputView.carNames();
        int repeatCount = InputView.repeatCount();

        RacingGame racingGame = new RacingGame(carNames, repeatCount, new RandomPowerGenerator());
        racingGame.start();
    }
}
