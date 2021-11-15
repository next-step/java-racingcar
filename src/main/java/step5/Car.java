package step5;

public class Car {

    private final CarName carName;
    private final MoveStrategy moveStrategy;
    private Position position;

    public Car(String carName, MoveStrategy moveStrategy) {
        this(carName, 0, moveStrategy);
    }

    public Car(String carName, int position, MoveStrategy moveStrategy) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
        this.moveStrategy = moveStrategy;
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    public boolean isWinner(Position winnerPos) {
        return this.position.equals(winnerPos);
    }

    public void move() {
        position = moveStrategy.move(position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Car.class)) {
            return false;
        }
        Car other = (Car) o;
        return (carName.equals(other.carName) && position.equals(other.position));
    }
}
