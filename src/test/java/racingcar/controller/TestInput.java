package racingcar.controller;

import java.util.List;
import racingcar.controller.extension.input.Inputable;

class TestInput implements Inputable {

    private final int expectedRound;
    private final List<String> expectedCarNames;

    TestInput(int expectedRound, List<String> expectedCarNames) {
        this.expectedRound = expectedRound;
        this.expectedCarNames = expectedCarNames;
    }

    @Override
    public int inputRound() {
        return expectedRound;
    }

    @Override
    public List<String> inputCarNames() {
        return expectedCarNames;
    }

}
