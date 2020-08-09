package racing.behavior;

import java.util.Random;

public class CarMovable implements Movable {
    private static final int MIN_MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_GENERATOR_BOUND = 10;

    @Override
    public boolean move() {
        return new Random().nextInt(RANDOM_NUMBER_GENERATOR_BOUND) >= MIN_MOVE_CONDITION;
    }
}
