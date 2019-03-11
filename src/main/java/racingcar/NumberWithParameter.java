package racingcar;

import java.util.Random;

public class NumberWithParameter implements RandomStrategy {
    private int number;

    public NumberWithParameter(int number) {
        this.number = number;
    }

    @Override
    public int makeRandomNumber() {
        return this.number;
    }
}
