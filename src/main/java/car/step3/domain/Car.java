package car.step3.domain;

import car.step3.service.MovingStrategy;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;


    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void go(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            this.position.move();
        }
    }

    public Position getMaxPosition(Position maxPosition) {
        if(maxPosition.lessThan(this.position)) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }

    public Position getPosition() {
        return this.position;
    }


    public Name getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(name, car.name)) return false;
        return Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
