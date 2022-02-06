package racingcar;

import java.util.stream.Collectors;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.movable.RandomMovableStrategy;
import racingcar.utils.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController game = GameController.of(InputView.readCarNames(), InputView.getTurn());

        game.startGame(RandomMovableStrategy.getInstance());
    }
}
