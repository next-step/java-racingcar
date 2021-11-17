package racingcar.car;

public class Car {
    private final int MOVABLE_CONDITION = 4;
    private int position;

    public Car() {
        position = 1;
    }

    public void move(int random) {
        if (random >= MOVABLE_CONDITION) {
            ++position;
        }
    }

    public int getPosition() {
        return position;
    }
}
