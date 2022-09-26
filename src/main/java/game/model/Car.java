package game.model;

public class Car {

    private int position = 0;

    public Car() {

    }

    public int getPosition() {
        return position;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isPossibleToMove()) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return position == car.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
