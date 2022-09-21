package step3.domain;

@FunctionalInterface
public interface NumberGenerator {
    int randomNumber();

    static NumberGenerator RandomNumberGenerator(int bound) {
        return new RandomNumberGenerator(bound);
    }
    static NumberGenerator RandomNumberGenerator() {
        return new RandomNumberGenerator(10);
    }


}
