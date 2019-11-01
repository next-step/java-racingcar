package racing;

public class Car {

    private final int MIN_POSITION_NUMBER = 0;
    private final int MOVE_CONDITION_NUMBER = 4;

    private int position;

    public Car() {
        this.position = MIN_POSITION_NUMBER;
    }

    public int move(int conditionValue) {
        return (conditionValue >= MOVE_CONDITION_NUMBER) ? position += 1 : position;
    }
}
