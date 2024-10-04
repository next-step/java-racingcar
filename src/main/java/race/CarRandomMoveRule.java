package race;

import java.util.Random;

public class CarRandomMoveRule implements CarMoveRule {
    private final Random RANDOM;
    private static final int BOUND_OF_RANDOM = 10;
    private static final int STANDARD = 4;

    private CarRandomMoveRule(Random random) {
        this.RANDOM = random;
    }

    public boolean check() {
        return this.RANDOM.nextInt(BOUND_OF_RANDOM) >= STANDARD;
    }

    public static CarRandomMoveRule create(Random random) {
        return new CarRandomMoveRule(random);
    }
}
