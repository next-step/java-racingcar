package game;

public class RandomlyMoveRule implements MoveRule {

    private RandomNumberProvider mRandomNumberProvider;

    public RandomlyMoveRule(RandomNumberProvider randomNumberProvider) {
        this.mRandomNumberProvider = randomNumberProvider;
    }

    @Override
    public boolean canMove() {
        return isValidRandomNumberForMove(mRandomNumberProvider.getRandomNumber());
    }

    private boolean isValidRandomNumberForMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
