package step4.strategy;

public class RacingGameWinMovementStrategy implements MovementStrategy {
    @Override
    public int doAction(int value) {
        return ++value;
    }
}
