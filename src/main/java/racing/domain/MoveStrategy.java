package racing.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMovable();
}
