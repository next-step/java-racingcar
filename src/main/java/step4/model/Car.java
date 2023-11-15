package step4.model;

import static step4.constants.CarConstants.MAX_CAR_NAME_LENGTH;

public class Car {

    private Position position;
    private final Name name;

    public Car(Name name) {
        verifyNameLength(name);
        this.name = name;
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public void go(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = this.position.move();
        }
    }

    private void verifyNameLength(Name name) {
        if (name.toString() == null || name.toString().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }

        if (name.toString().length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public Name getName() {
        return this.name;
    }
}
