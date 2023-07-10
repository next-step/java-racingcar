package racing.model.generator;

public class RandomNumberGenerator implements NumberGenerator {

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        return RandomNumberGeneratorLazyHolder.INSTANCE;
    }

    private static class RandomNumberGeneratorLazyHolder {
        private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();
    }

    @Override
    public int generate() {
        return (int) (Math.random() * 10);
    }
}
