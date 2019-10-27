package game;

public class RandomlyMoveRule implements MoveRule {

    @Override
    public boolean canMove() {
        return isValidRandomNumberForMove(0);
    }

    private boolean isValidRandomNumberForMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
