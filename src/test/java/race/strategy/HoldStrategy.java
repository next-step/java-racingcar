package race.strategy;

public class HoldStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}