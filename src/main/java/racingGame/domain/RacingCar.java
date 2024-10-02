package racingGame.domain;

public class RacingCar {
    private final int MAX_NAME_LENGTH = 5;
    private int position;
    private final String name;
    private final MovementCondition movementCondition;

    public RacingCar(String name, MovementCondition movementCondition) {
        validateName(name);
        this.position = 0;
        this.name = name;
        this.movementCondition = movementCondition;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void move() {
        if (movementCondition.canMove()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
