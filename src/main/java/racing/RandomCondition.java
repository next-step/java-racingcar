package racing;

import java.util.Random;

public class RandomCondition implements MovingCondition{
    @Override
    public int getCondition() {
        return new Random().nextInt(10);
    }
}
