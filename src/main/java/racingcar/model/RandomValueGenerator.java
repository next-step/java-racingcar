package racingcar.model;

@FunctionalInterface
public interface RandomValueGenerator {

    int nextValue(int bound);

}
