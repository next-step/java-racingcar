package racingcar;

import racingcar.logic.DefaultCarEngine;
import racingcar.logic.RandomValueProvider;
import racingcar.view.input.DefaultInputView;
import racingcar.view.result.DefaultResultView;
import racingcar.view.input.CommandLineReader;

public class Main {
    public static void main(String[] args) {
        GameContext gameContext = new GameContext(
                new DefaultInputView(new CommandLineReader()),
                new DefaultResultView(),
                new DefaultCarEngine(new RandomValueProvider(10)));
        gameContext.run();
    }
}
