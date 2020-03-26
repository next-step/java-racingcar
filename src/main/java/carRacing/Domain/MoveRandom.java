package carRacing.Domain;

import carRacing.Constants;

import java.util.Random;


public class MoveRandom implements MoveStrategy {

    Random random;

    public MoveRandom(Random random) {
        this.random = random;
    }

    @Override
    public boolean movable() {
        return (random.nextInt(Constants.MOVE_PERCENT_DENOMINATOR) >= Constants.MOVE_PERCENT_NUMERATOR);
    }
}
