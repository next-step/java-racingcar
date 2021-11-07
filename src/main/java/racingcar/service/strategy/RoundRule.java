package racingcar.service.strategy;

@FunctionalInterface
public interface RoundRule {
    boolean checkCondition();
}
