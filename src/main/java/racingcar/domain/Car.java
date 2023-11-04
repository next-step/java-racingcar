package racingcar.domain;

public class Car {

    private static final int MOVE_GRADE = 1;

    private final RandomPicker randomPicker;

    private int grade = 1;

    public Car(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
    }

    public int grade() {
        return grade;
    }

    public void game() {
        GameNumber gameNumber = randomPicker.pickNumber();

        if (gameNumber.isMovableNumber()) {
            moveForward();
        }
    }

    private void moveForward() {
        this.grade = grade + MOVE_GRADE;
    }
}
