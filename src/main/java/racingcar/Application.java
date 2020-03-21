package racingcar;

import racingcar.domain.GameRole;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class Application {
    private static final int ADVANCE_COUNT = 1;

    public static void main(String[] args) {
        InputView view = new InputView();
        view.input();

        GameRole gameRole = new GameRole(ADVANCE_COUNT);
        RacingGame racingGame = new RacingGame(view.getTime(), view.getNumber(), gameRole);
        racingGame.start();
    }
}
