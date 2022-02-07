package racinggame.domain;

import static racinggame.domain.random.RandomGoRule.GO_MIN_VALUE;

import racinggame.domain.random.GoRule;

public class GoRandom implements GoRule {

    private static final int GO_VALUE = 5;

    @Override
    public boolean isGo() {
        if (GO_VALUE >= GO_MIN_VALUE) {
            return true;
        }
        return false;
    }
}
