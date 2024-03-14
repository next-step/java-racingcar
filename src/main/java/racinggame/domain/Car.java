package racinggame.domain;

public class Car implements Comparable<Car>{
    private Position position;
    private Name name;

    public Car(String name) {
        this.name = Name.create(name);
        this.position = Position.create();
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMoving()) {
            position = position.move();
        }
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position.compareTo(otherCar.position);
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return name;
    }
}
