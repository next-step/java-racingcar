package carracing.domain;

@FunctionalInterface
public interface MovingStrategy {
    boolean canMove();
}
