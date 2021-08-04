package carracing.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean movable();
}
