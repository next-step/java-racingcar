package racingcar;

public class Car {

    private static final int MOVE_GRADE = 1;

    private static final int MOVABLE_MIN_NUMBER = 4;

    private final RandomPicker randomPicker;

    private int grade = 1;

    public Car(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    public int grade() {
        return grade;
    }

    public void game() {
        if (isMovable(randomPicker.pickNumber())) {
            moveForward();
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_MIN_NUMBER;
    }

    private void moveForward() {
        this.grade = grade + MOVE_GRADE;
    }
}
