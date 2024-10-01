public class MockRandomNumberGenerator implements RandomNumberGenerator {
    private int value;

    public MockRandomNumberGenerator(int value) {
        this.value = value;
    }

    @Override
    public int generate() {
        return this.value;
    }
}
