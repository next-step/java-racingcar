package carracing.cars;

import carracing.utils.RandomFactory;

public class RandomStepForwardStrategy implements StepForwardStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final int MIN_FORWARD = 4;

    @Override
    public boolean stepForward() {
        int random = RandomFactory.generate(RANDOM_BOUND);
        return random >= MIN_FORWARD;
    }
}
