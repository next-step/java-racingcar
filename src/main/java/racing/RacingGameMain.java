package racing;

import racing.domain.RacingGame;
import racing.domain.RandomPowerGenerator;
import racing.view.InputView;

public class RacingGameMain {
    public static void main(String[] args) {
        int carCount = InputView.carCount();
        int repeatCount = InputView.repeatCount();

        RacingGame racingGame = new RacingGame(carCount, repeatCount, new RandomPowerGenerator());
        racingGame.start();
    }
}
