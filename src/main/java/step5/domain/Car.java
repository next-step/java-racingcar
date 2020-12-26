package step5.domain;

public class Car {

    private MoveDistance moveDistance;
    private Name name;


    public Car() {
    }

    public Car(String carName) {
        moveDistance = new MoveDistance();
        name = new Name(carName);
    }

    public Car(int moveDistance, String name) {
        this.moveDistance = new MoveDistance(moveDistance);
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            moveDistance.move();
        }
    }

    public boolean isWinner(int maxPosition) {
        return moveDistance.isSamePosition(maxPosition);
    }

    public int max(int maxPosition) {
        return moveDistance.isMaxPosition(maxPosition);
    }

    public int carPosition() {
        return moveDistance.getMoveDistance();
    }
}
