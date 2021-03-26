package step3to5.utils;

public class TestNumberGenerator implements NumberGenerator {

    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getRandom() {
        return number;
    }
}
