package test_util;

import util.NumberGenerator;

public class NumberGeneratorByInputNumber implements NumberGenerator {
    private int number = 0;

    public NumberGeneratorByInputNumber(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}
