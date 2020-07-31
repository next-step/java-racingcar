package camp.nextstep.edu.rebellion.racing.rule;

import java.util.Random;

public class RandomMoveRule implements RacingRule {
    private final Random RANDOM = new Random();
    private final int PASS_CONDITION = 4;
    @Override
    public boolean pass() {
        return PASS_CONDITION <= RANDOM.nextInt(10);
    }
}
