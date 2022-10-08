package step5.domain;

public class Car {

    MovingStrategy movingStrategy = new RandomMovingStrategy();

    private Position position;
    private final CarName carName;

    public Car(String name) {
        this.position = new Position();
        this.carName = new CarName(name);
    }

    public void move(int value) {
        if (movingStrategy.isMovable(value)) {
            position = position.move();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getName();
    }

}
