package woowacamp.racingcar.domain;

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
        int distance = strategy.distance();
        this.position = position.move(distance);
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

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
