package racinggame.domain;

import racinggame.utils.StringUtils;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final Name name;
    private Position position = new Position();

    public Car(final String name) {
        this.name = new Name(name);
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM)
            this.position = position.increase();
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
