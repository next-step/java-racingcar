package step5.domain;

public class Car {

    private final Position position;
    private final CarName carName;

    public Car(String name) {
        this.position = new Position();
        this.carName = new CarName(name);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }

}
