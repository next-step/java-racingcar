package racing;

import java.util.Random;

public class Car {
    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;
    public static final CarMoveConditionProvider mustGoMoveConditionProvider = () -> true;
    public static final CarMoveConditionProvider randomMoveConditionProvider = () -> new Random().nextInt(MOVE_POWER_BOUND) > DEFAULT_MOVE_POWER_CONDITION;
    private int position = 1;

    CarMoveConditionProvider provider;

    public Car(CarMoveConditionProvider provider) {
        this.provider = provider;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (provider.isMovable()) {
            this.position += 1;
        }
    }
}
