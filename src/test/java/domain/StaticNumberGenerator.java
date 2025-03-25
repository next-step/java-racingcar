package domain;

public class StaticNumberGenerator implements NumberGenerator {
    private static int NUMBER;

    public StaticNumberGenerator(int number) {
        NUMBER = number;
    }

    @Override
    public int generate() {
        return NUMBER;
    }
}