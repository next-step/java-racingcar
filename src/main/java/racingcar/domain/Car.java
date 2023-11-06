package racingcar.domain;

public class Car {

    private static final int MOVE_GRADE = 1;

    private final RandomPicker randomPicker;

    private final String name;

    private int grade = 1;

    private Car(String name, RandomPicker randomPicker) {
        this.name = name;
        this.randomPicker = randomPicker;
    }

    public static Car create(String name, RandomPicker randomPicker) {
        checkNameIsValid(name);

        return new Car(name, randomPicker);
    }

    private static void checkNameIsValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int grade() {
        return grade;
    }

    public CarStatus game() {
        GameNumber gameNumber = randomPicker.pickNumber();

        if (gameNumber.isMovableNumber()) {
            moveForward();
        }

        return new CarStatus(name, grade);
    }

    private void moveForward() {
        this.grade += MOVE_GRADE;
    }
}
