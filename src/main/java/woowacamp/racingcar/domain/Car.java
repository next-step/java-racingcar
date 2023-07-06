package woowacamp.racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int BOUNDARY = 4;

    private final Name name;

    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(NumberGenerator strategy) {
        int number = strategy.number();
        if (number >= BOUNDARY) {
            this.position = position.forward();
        }
    }

    public boolean isEqualPosition(Position position) {
        return this.position.equals(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }
}
