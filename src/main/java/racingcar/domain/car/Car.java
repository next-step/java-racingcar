package racingcar.domain.car;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private int location;

    public int move(int randomNumber) {
        if (isMoveable(randomNumber)) {
            location++;
        }

        return location;
    }

    private boolean isMoveable(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }
}
