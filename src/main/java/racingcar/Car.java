package racingcar;

public class Car {
    private Name name;
    private Position position;

    public Car(String carName) {
        this.name = new Name(carName);
        position = new Position();
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(String carName, int position) {
        this(new Name(carName), new Position(position));
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
