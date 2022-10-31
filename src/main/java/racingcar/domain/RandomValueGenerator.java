package racingcar.domain;

@FunctionalInterface
public interface RandomValueGenerator {

    int nextValue(int bound);

}
