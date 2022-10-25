package racingCar;

public class RandomMoveStrategy implements MoveStrategy {

    public boolean canMove(final int randomNumber) {
        return randomNumber <= 4;
    }
}
