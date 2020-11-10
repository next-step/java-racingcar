package study.racing;

public class AlwaysForwardStrategy implements RacingMoveStrategy {

    @Override
    public int getMovement() {
        return 1;
    }
}
