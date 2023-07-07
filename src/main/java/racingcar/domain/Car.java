package racingcar.domain;

public class Car {
    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final MoveStrategy strategy) {
        final int amount = strategy.amount();
        this.position = position.move(amount);
    }

    public boolean isSamePositionWith(final Car car) {
        return this.getPositionDifferenceWith(car) == 0;
    }

    public int getPositionDifferenceWith(final Car car) {
        return this.position.getDifferenceWith(car.position);
    }

    public String getNameValue() {
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public int getPositionValue() {
        return position.getValue();
    }
}
