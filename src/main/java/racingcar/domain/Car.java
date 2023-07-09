package racingcar.domain;

public class Car implements Comparable<Car> {
    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy strategy) {
        int amount = strategy.amount();
        this.position = position.move(amount);
    }

    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
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

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
