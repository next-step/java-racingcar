package racingcar;

@FunctionalInterface
public interface RandomValueGenerator {

    int nextValue(int bound);

}
