package car_racing.domain.strategy;

public class AlwaysMovingStrategy implements CarMovingStrategy {
    @Override
    public boolean movable() {
        return true;
    }
}
