package step3.generator;

import step3.generator.GenerateNumberStrategy;

import java.util.Random;

public class TestNumberGenerator implements GenerateNumberStrategy {

    private final int num;

    public TestNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public int generateNumber() {
        return num;
    }
}
