package racinggame.mvc.domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int FORWARD_THRESHOLD = 4;

    private final CarName name;
    private final Position position;

    public Car(CarName name, Position position) {
        this.name = Objects.requireNonNull(name);
        this.position = Objects.requireNonNull(position);
    }

    public Car(CarName name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, int position) {
        this(new CarName(name), position);
    }

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public void move(int number) {
        if (canMove(number)) {
            position.advance();
        }
    }

    private boolean canMove(int number) {
        return number >= FORWARD_THRESHOLD;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
