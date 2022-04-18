package racingcar.domain;

import java.util.Random;

public class RaceCondition implements Condition {
    int range;
    int condition;

    public static Random random = new Random();

    public RaceCondition(int range, int condition) {
        this.range = range;
        this.condition = condition;
    }

    @Override
    public boolean getCondition() {
        return random.nextInt(range) > condition;
    }
}
