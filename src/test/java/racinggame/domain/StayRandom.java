package racinggame.domain;

import racinggame.domain.random.RandomRule;

public class StayRandom  implements RandomRule {

    private static final int STAY_VALUE=1;

    @Override
    public int getRandomValue() {
        return STAY_VALUE;
    }
}
