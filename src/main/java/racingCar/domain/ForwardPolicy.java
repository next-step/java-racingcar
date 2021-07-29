package racingCar.domain;

@FunctionalInterface
public interface ForwardPolicy {

    boolean isMovableNumber(int number);
}
