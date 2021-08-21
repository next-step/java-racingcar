package race;

import java.util.Random;

public class RandomNumCondition implements MoveCondition {

    private final int STANDARD_NUM = 4;

    public RandomNumCondition() {
        getValue();
    }

    protected static final Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(10);
    }

    @Override
    public void moveOrNot(Car car) {
        if(getValue() >= STANDARD_NUM)
            car.addDistance();
    }
}
