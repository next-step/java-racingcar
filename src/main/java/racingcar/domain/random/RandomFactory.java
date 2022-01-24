package racingcar.domain.random;

public class RandomFactory {

    private RandomFactory() {}

    public static RandomFactory get() {
        return new RandomFactory();
    }

    public int getRandom(RandomStrategy randomStrategy) {
        return randomStrategy.get();
    }
}
