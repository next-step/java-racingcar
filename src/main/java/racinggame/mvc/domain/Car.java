package racinggame.mvc.domain;

import java.util.Objects;

public class Car {

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
        this(name, 0);
    }

    public void move(int threshold) {
        if (threshold < 4) {
            return;
        }

        position.advance();
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }
}
