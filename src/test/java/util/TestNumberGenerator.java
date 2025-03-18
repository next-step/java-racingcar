package util;

public class TestNumberGenerator implements RandomGenerator {
    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
