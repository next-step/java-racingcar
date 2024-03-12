package racingcar.utils;

import racingcar.domain.Number;

public class TestNumber implements Number {

    private final int number;

    public TestNumber(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
