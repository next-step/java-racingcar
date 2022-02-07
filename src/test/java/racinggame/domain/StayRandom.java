package racinggame.domain;

import static racinggame.domain.random.RandomGoRule.GO_MIN_VALUE;

import racinggame.domain.random.GoRule;

public class StayRandom implements GoRule {

    private static final int STAY_VALUE = 1;

    @Override
    public boolean isGo() {
        if (STAY_VALUE >= GO_MIN_VALUE) {
            return true;
        }
        return false;
    }
}
