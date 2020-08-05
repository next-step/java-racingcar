package racingcar.domain;

@FunctionalInterface
public interface MovementRule {
    boolean isEnoughFuel(int fuel);
}
