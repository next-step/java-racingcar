package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        GameController game = GameController.of(InputView.readCarNames(), InputView.getTurn());

        game.startGame(RandomMovableStrategy.getInstance());
    }
}
