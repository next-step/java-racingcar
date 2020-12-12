package racing;

import racing.domain.RandomNumberGenerator;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private int number;
    public TestRandomNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNum() {
        return number;
    }
}
