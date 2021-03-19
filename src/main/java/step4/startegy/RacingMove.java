package step4.startegy;

import java.util.Random;

public final class RacingMove implements Move {

    private final int MINIMUM = 4;
    private final int MAXIMUM = 9;
    private final int STANDARD = 10;
    private final Random random;

    public RacingMove() {
        random = new Random();
    }

    @Override
    public boolean isMovable() {
        int value = random.nextInt(STANDARD);
        return (MINIMUM <= value && value <= MAXIMUM);
    }

}
