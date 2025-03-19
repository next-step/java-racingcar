package NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private final int number;

    public TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate(int min, int max) {
        return number;
    }
}
