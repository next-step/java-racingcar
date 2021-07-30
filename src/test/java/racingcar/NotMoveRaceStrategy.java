package racingcar;

public class NotMoveRaceStrategy implements RaceStrategy {
    @Override
    public boolean decideToMove() {
        return false;
    }
}
