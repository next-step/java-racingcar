package race;

public class FixedNumberGenerator implements RandomNumberGenerator {
    private final int fixedValue;

    public FixedNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
