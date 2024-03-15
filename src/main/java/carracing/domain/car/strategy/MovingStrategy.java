package carracing.domain.car.strategy;

@FunctionalInterface
public interface MovingStrategy {
    boolean isMovable();
}
