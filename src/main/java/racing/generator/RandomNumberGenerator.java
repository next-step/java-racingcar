package racing.generator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return (int) (Math.random() * 10);
    }
}
