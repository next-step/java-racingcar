package game;

public class RandomlyMoveRule implements MoveRule {

    private static final int MIN_VALID_RANDOM_NUMBER = 4;

    private RandomNumberProvider mRandomNumberProvider;

    public RandomlyMoveRule(RandomNumberProvider randomNumberProvider) {
        this.mRandomNumberProvider = randomNumberProvider;
    }

    @Override
    public boolean canMove() {
        return isValidRandomNumberForMove(mRandomNumberProvider.getRandomNumber());
    }

    private boolean isValidRandomNumberForMove(int randomNumber) {
        return randomNumber >= MIN_VALID_RANDOM_NUMBER;
    }
}
