package racingcar;

import racingcar.logic.DefaultCarEngine;
import racingcar.logic.RandomValueProvider;
import racingcar.view.input.DefaultInputView;
import racingcar.view.result.DefaultResultView;
import racingcar.view.input.CommandLineReader;

public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(
                new DefaultInputView(new CommandLineReader()),
                new DefaultResultView(),
                new DefaultCarEngine(new RandomValueProvider(10)));
        racingGame.run();
    }
}
