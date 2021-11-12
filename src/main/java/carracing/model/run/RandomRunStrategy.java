package carracing.model.run;

import carracing.util.RandomUtils;

public class RandomRunStrategy implements RunStrategy {

    private static final Integer MIN_FORWARD_NUMBER = 4;

    @Override
    public boolean isRun() {
        return RandomUtils.nextInt() >= MIN_FORWARD_NUMBER;
    }
}
