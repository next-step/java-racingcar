package step3.common;

public class FixNumberGenerator implements NumberGenerator {
    private int number;

    public FixNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
