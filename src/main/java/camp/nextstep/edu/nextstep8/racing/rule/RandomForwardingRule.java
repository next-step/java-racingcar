package camp.nextstep.edu.nextstep8.racing.rule;

import java.util.Random;

public class RandomForwardingRule implements ForwardingRule {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_RANGE = 10;
    private static final int FORWARD_STANDARD_VALUE = 4;

    @Override
    public boolean canForward() {
        return FORWARD_STANDARD_VALUE <= RANDOM.nextInt(RANDOM_RANGE);
    }
}
