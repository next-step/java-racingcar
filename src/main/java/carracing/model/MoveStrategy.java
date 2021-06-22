package carracing.model;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMovable();
}
