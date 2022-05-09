package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.util.Strategy;

public class Car {
    public static final String NAME_DELIMITER = " : ";

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position findMaxPosition(Position maxPosition) {
        if(position.isBiggerThan(maxPosition))  return position;
        return maxPosition;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public void move(Strategy moveStrategy) {
        position.move(moveStrategy);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(name.toString()).append(NAME_DELIMITER).append(position.toString());
        return out.toString();
    }

    public String toStringName() {
        return name.toString();
    }
}
