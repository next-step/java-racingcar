package racingcar.domain;

public class Car {
    private MoveCondition moveCondition;
    private int position;
    private String name;
    private final int MOVE_POSITION = 1;
    private final int NAME_MAX_LENGTH = 5;

    public Car(MoveCondition moveCondition) {
        this.position = 0;
        this.moveCondition = moveCondition;
    }

    public Car(String name) {
        checkLength(name);
        this.position = 0;
        this.name = name;
    }

    private void checkLength(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int move(int num) {
        if (moveCondition.isMovable(num)) {
            this.position += MOVE_POSITION;
        }
        return position;
    }
}
