package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.moving.DefaultMovingStrategy;
import racingcar.domain.moving.RandomValueProvider;
import racingcar.view.input.DefaultInputView;
import racingcar.view.result.DefaultResultView;
import racingcar.view.input.CommandLineReader;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new DefaultInputView(new CommandLineReader()),
                new DefaultResultView(),
                new RacingGame(new DefaultMovingStrategy(new RandomValueProvider(10))));
        gameController.run();
    }
}
