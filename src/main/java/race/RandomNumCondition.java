package race;

import java.util.Random;

public class RandomNumCondition implements MoveCondition {

    private static final int STANDARD_NUM = 4;

    public RandomNumCondition() {
        getValue();
    }

    protected static final Random random = new Random();

    @Override
    public int getValue() {
        return random.nextInt(10);
    }

   public static String move(MoveCondition moveCondition) {
        if (moveCondition.getValue() >= STANDARD_NUM)
            return "-";
        return "";
    }
}
