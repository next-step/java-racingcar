package util;

public class TestNumberGenerator implements NumberGenerator {
    private int number = 0;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getRandomNumber() {
        return number;
    }
}
