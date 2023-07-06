package racing.generator;


/**
 * This Class is for test.
 */
public class SpecificNumberGenerator implements NumberGenerator {
    private final int value;

    public SpecificNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}
