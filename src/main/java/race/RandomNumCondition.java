package race;

import java.util.Random;

public class RandomNumCondition implements MoveCondition {

    public RandomNumCondition() {
        getValue();
    }

    protected static final Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(10);
    }
}
