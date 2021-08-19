package car.domain;

@FunctionalInterface
public interface MovingStrategy {
    boolean isMovable(int inputNumber);
}
