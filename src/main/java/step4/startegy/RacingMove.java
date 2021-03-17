package step4.startegy;

import java.util.Random;

public final class RacingMove implements Move {

    private final int MINIMUM = 4;
    private final int MAXIMUM = 9;
    private final int value;

    public RacingMove() {
        value = new Random().nextInt(10);
    }

    @Override
    public boolean isMovable() {
        return (MINIMUM <= value && value <= MAXIMUM);
    }

}
