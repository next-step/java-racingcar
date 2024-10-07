package race;

import java.util.Random;

public class CarRandomMoveRuleValue implements CarMoveRuleValue {
    private static final Random RANDOM = new Random();
    private final int randomValue;

    private CarRandomMoveRuleValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public static CarRandomMoveRuleValue create(int bound) {
        int randomValue = RANDOM.nextInt(bound);
        return new CarRandomMoveRuleValue(randomValue);
    }

    public boolean isGreaterThanOrEqualTo(int number) {
        return this.randomValue >= number;
    }
}
