package study.racinggame.domain.strategy;

public class RaceGameMoveStrategy implements MoveStrategy {
    final static int MINIMUM_MOVEMENT_NUMBER = 4;

    @Override
    public boolean canMove(int number) {
        return number >= MINIMUM_MOVEMENT_NUMBER;
    }
}