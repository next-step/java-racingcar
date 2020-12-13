package racing.domain;

import java.util.Objects;

public class Car {
    private Position position;
    private Name name;

    public Car(String name) {
        this.position = new Position();
        this.name = new Name(name);
    }

    public Car(String name, int position) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public Name getName() {
        return this.name;
    }

    public void move(RandomNumber randomNumber) {
        if(randomNumber.canMove()) {
            position.move();
        }
    }

    public boolean isWinner(int maxPosition) {
        return position.samePosition(maxPosition);
    }

    public int max(int maxPosition) {
        if(position.isGreaterThan(maxPosition)) {
            return position.getPosition();
        }
        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!Objects.equals(position, car.position)) return false;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public int getPosition() {
        return this.position.getPosition();
    }
}
