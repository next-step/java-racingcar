package step2.utils;

public class MoveIndicator {
    private final static int MOVE_CRITERION = 4;

    public boolean canMove(RandomNumberGenerator generator) {
        final int randomNumber = generator.getRandomNumber();
        if (randomNumber >= MOVE_CRITERION) {
            return true;
        }
        return false;
    }
}
