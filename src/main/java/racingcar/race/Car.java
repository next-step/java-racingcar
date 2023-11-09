package racingcar.race;

import racingcar.domain.Position;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    public static final String EMPTY_NAME = "EMPTY";

    private final String name;
    private final Position position;

    public Car() {
        this(EMPTY_NAME);
    }

    public Car(String name) {
        this(name, new Position(0));
    }

    public Car(String name, Position position) {
        validationName(name);
        this.name = name;
        this.position = position;
    }

    private void validationName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(" 자동차 이름은 5자를 초과할 수 없습니다. - " + name);
        }
    }

    public void move() {
        position.move();
    }

    public String name() {
        return name;
    }

    public Position position() {
        return position;
    }
}
