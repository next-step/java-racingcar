package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView view = new InputView();
        view.input();

        RacingGame racingGame = new RacingGame(view.getTime(), view.getNumber());
        racingGame.start();
    }
}
