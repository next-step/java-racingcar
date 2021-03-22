package step5.domain;

public class Car {
    private final String carName;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }

    public String getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
