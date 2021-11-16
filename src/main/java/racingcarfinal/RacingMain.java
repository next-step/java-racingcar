package racingcarfinal;

import racingcarfinal.domain.RacingGame;
import racingcarfinal.ui.InputView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        RacingGame game = new RacingGame(carNames, tryCount);
        while (!game.isEnd()) {
            game.play();
        }
    }

}
