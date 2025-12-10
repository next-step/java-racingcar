package step5.racing.domain;

public class Car {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(new CarName(name), new Position(0));
    }

    public Car(CarName carName) {
        this(carName, new Position(0));
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position = position.move();
        }
    }

    public Position position() {
        return this.position;
    }

    public CarName name() {
        return this.name;
    }
}
