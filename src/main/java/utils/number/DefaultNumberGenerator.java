package utils.number;

public class DefaultNumberGenerator implements NumberGenerator {
    private final int number;

    public DefaultNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
