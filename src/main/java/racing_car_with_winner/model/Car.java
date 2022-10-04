package racing_car_with_winner.model;

public class Car {
    private final CarName carName;
    private final MoveResult moveResult;

    public Car(CarName carName) {
        this.carName = carName;
        this.moveResult = new MoveResult();
    }

    public Car(CarName carName, MoveResult moveResult) {
        this.carName = carName;
        this.moveResult = moveResult;
    }

    public Car tryMove(MovableStrategy movableStrategy) {
        return new Car(this.carName, moveResult.move(movableStrategy.canMove()));
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
