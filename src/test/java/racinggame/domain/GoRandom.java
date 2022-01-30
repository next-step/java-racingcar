package racinggame.domain;

import racinggame.domain.random.RandomGenerator;
import racinggame.domain.random.RandomRule;

public class GoRandom implements RandomRule {

    private final int GO_VALUE=5;

    @Override
    public int getRandomValue() {
        return GO_VALUE;
    }
}
