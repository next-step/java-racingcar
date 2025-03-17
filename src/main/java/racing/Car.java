package racing;

import java.util.Random;

public class Car {
    public static final int MOVE_POWER_BOUND = 10;
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;
    private int position = 1;
    private int movePowerCondition;

    public Car() {
        this( ()->DEFAULT_MOVE_POWER_CONDITION );
    }

    public Car(CarMovePowerProvider provider) {
        this.movePowerCondition = provider.getMovePower();
    }

    public int getPosition() {
        return position;
    }

    public void move(CarMovePowerProvider provider) {
        int movePower = provider.getMovePower();
        if (movePower >= movePowerCondition) {
            this.position += 1;
        }
    }
}
