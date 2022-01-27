package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        new GameController(InputView.readCarNames(), InputView.getTurn())
            .play(new RandomMovableStrategy());
    }
}
