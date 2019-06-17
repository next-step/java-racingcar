package racingcar;

import racingcar.logic.DefaultGameLogic;
import racingcar.logic.RandomValueProvider;
import racingcar.view.input.DefaultInputView;
import racingcar.view.result.DefaultResultView;
import racingcar.view.input.NumberInputReader;

public class Main {
    public static void main(String[] args) {
        GameContext gameContext = new GameContext(
                new DefaultInputView(new NumberInputReader()),
                new DefaultResultView(),
                new DefaultGameLogic(new RandomValueProvider(10)));
        gameContext.run();
    }
}
