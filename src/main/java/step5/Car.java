package step5;

public class Car {

    private CarName carName;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = new CarName(carName);
        this.position = new Position(0);
        this.moveStrategy = moveStrategy;
    }

    public boolean isWinner(Position winnerPos) {
        return this.position.equals(winnerPos);
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
