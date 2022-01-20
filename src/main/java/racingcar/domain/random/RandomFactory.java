package racingcar.domain.random;

public class RandomFactory {

    public RandomFactory() {}

    public int getRandom(RandomStrategy randomStrategy) {
        return randomStrategy.get();
    }
}
