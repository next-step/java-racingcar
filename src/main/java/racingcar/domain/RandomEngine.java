package racingcar.domain;

public class RandomEngine implements Engine{
    @Override
    public int getPower() {
        return RandomGenerator.getRandomValue();
    }
}
