package race;

class MockRandomValueGenerator implements IRandomValueGenerator {
    private final int randomValue;

    private MockRandomValueGenerator(int randomValue) {
        this.randomValue = randomValue;
    }

    @Override
    public int generateFromZeroTo(int _end) {
        return randomValue;
    }

    public static MockRandomValueGenerator createThatGenerate(int randomValue) {
        return new MockRandomValueGenerator(randomValue);
    }
}
