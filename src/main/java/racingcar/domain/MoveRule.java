package racingcar.domain;

@FunctionalInterface
public interface MoveRule {
    boolean isAbleToMove();
}
