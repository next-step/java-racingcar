package racingcar.domain;

@FunctionalInterface
public interface MovingPolicy {
    Integer nextStep();
}
