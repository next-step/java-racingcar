package racingcar.view.input;

import racingcar.view.input.NumberInputReader;

public class MockNumberInputReader extends NumberInputReader {

    private Integer result;

    MockNumberInputReader(Integer result) {
        this.result = result;
    }

    @Override
    public Integer get() {
        return result;
    }
}
