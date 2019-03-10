package racingcar;

public class TestRandomGenerator implements RandomGenerator {
    private int value;

    public TestRandomGenerator(int value) {
        this.value = value;
    }

    @Override
    public int getRandomValue() {
        return this.value;
    }
}
