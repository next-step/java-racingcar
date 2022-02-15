package racing.domain;

@FunctionalInterface
public interface MoveRule {
    boolean isMovable();
}
