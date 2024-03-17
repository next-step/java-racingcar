package RacingGame;

import RacingGame.common.NumberGenerator;

public class FixNumberGenerator implements NumberGenerator {
    private final int number;

    public FixNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
