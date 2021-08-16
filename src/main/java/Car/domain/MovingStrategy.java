package Car.domain;

@FunctionalInterface
public interface MovingStrategy {
    boolean isMove(int inputNumber);
}
