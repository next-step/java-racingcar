package racing;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class Car {
    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;
    public static final BooleanSupplier mustGoMoveConditionSupplier = () -> true;
    public static final BooleanSupplier randomMoveConditionSupplier = () -> new Random().nextInt(MOVE_POWER_BOUND) >= DEFAULT_MOVE_POWER_CONDITION;

    private int position = 1;
    BooleanSupplier moveConditionSupplier;

    public Car(BooleanSupplier moveConditionSupplier) {
        this.moveConditionSupplier = moveConditionSupplier;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (this.moveConditionSupplier.getAsBoolean()) {
            this.position += 1;
        }
    }
}
