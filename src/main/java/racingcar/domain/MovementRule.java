package racingcar.domain;

@FunctionalInterface
public interface MovementRule {
    boolean isEnoughPower(int power);
}
