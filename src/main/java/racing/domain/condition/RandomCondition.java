package racing.domain.condition;

import java.util.Random;

public class RandomCondition implements MovingCondition{
    private final Random random;

    public RandomCondition() {
        random = new Random();
    }

    @Override
    public int getCondition() {
        return random.nextInt(10);
    }
}
