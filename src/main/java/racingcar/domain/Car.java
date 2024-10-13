package racingcar.domain;


public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }


    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }

    public boolean isSamePosition(Car farthestCar) {
        return position.equals(farthestCar.position);
    }
}
