package racing.domain;

import racing.strategy.MovingStrategy;

public class Car implements Comparable<Car> {

    private final String name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int moveNumber) {
        this.name = name;
        this.position = new Position(moveNumber);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return o.position.compareTo(this.position);
    }
}
