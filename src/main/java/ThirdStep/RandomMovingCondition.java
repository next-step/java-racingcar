package ThirdStep;

import ThirdStep.interfaces.MovingCondition;

import java.util.Random;

public class RandomMovingCondition implements MovingCondition {

    public static final int RANDOM_NUMBER_BOUND = 10;
    public static final int FORWARD_CRITERIA = 4;

    public static final Random RANDOM_GENERATOR = new Random();

    public static RandomMovingCondition create() {
        return new RandomMovingCondition();
    }

    @Override
    public boolean canMoveForward() {
        return RANDOM_GENERATOR.nextInt(RANDOM_NUMBER_BOUND) >= FORWARD_CRITERIA;
    }
}
