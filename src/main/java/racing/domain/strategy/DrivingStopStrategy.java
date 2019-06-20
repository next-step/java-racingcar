package racing.domain.strategy;

public class DrivingStopStrategy implements DrivingStrategy {
    @Override
    public boolean isMovable() { return false; }
}
