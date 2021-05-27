package racing.domain;

@FunctionalInterface
public interface MoveConditionStrategy {
    boolean isMovable();
}