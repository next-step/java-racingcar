package racing;

public class Car {
    public static final int DEFAULT_MOVE_POWER_CONDITION = 4;
    private int position = 1;
    private int movePowerCondition;

    public Car() {
        this.movePowerCondition = DEFAULT_MOVE_POWER_CONDITION;
    }

    public Car(int movePowerCondition) {
        this.movePowerCondition = movePowerCondition;
    }

    public int getPosition() {
        return position;
    }

    public void move(int movePower) {
        if (movePower >= movePowerCondition) {
            this.position += 1;
        }
    }
}
