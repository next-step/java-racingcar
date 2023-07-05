package racing.generator;

import racing.generator.NumberGenerator;

/**
 * This Class is for test.
 */
public class SpecificNumberGenerator implements NumberGenerator {
    private int value;

    public SpecificNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}
