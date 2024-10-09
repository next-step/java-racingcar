package race.domain;

import java.util.Random;

public class CarRandomMoveRule implements CarMoveRule {
    public static final Random RANDOM = new Random();
    public static final int BOUND_OF_RANDOM = 10;
    private static final int STANDARD = 4;

    private CarRandomMoveRule() {}

    @Override
    public boolean movable() {
        return RANDOM.nextInt(BOUND_OF_RANDOM) >= STANDARD;
    }

    public static CarRandomMoveRule create() {
        return new CarRandomMoveRule();
    }
}
