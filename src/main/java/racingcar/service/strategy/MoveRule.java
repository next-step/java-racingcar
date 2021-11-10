package racingcar.service.strategy;

@FunctionalInterface
public interface MoveRule {
    boolean moveOrNot();
}
