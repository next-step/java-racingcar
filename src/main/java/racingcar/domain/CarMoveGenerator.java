package racingcar.domain;

@FunctionalInterface
public interface CarMoveGenerator {
    boolean advance();
}
