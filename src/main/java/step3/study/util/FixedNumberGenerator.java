package step3.study.util;

public class FixedNumberGenerator implements NumberGenerator{
    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int createNumber() {
        return this.number;
    }
}
