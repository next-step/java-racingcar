package racingcar.domain;

public class Car {
    private final Name name;
    private Position position;

    public Car(String carName) {
        this(new Name(carName), new Position());
    }

    public Car(String carName, int position) {
        this(new Name(carName), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String name() {
        return this.name.get();
    }

    public int position() {
        return this.position.get();
    }

    public int max(int other) {
        return position.max(other);
    }

    public void updatePosition(int randomValue) {
        position.updatePosition(randomValue);
    }

    public boolean isMatch(int maxPosition) {
        return position.isMatch(maxPosition);
    }
}
