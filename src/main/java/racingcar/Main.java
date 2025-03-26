package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(), new ResultView(), new BoundaryRandomNumberGenerator());
        racingGame.play();
    }
}
