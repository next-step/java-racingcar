package racingGame;

import racingGame.game.RacingGameRule;

public class FakeCarForwardRule implements RacingGameRule {

    private static final int CAR_FORWARD_STANDARD = 4;
    private int randomNumber;

    @Override
    public boolean result() {
        return randomNumber >= CAR_FORWARD_STANDARD;
    }

    public void injectionRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }
}
