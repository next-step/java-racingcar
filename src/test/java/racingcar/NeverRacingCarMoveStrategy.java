package racingcar;

public class NeverRacingCarMoveStrategy implements RacingCarMoveStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
