package step4.domain;

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

    public int getPosition() {
        return moveDistance.getMoveDistance();
    }

    public String getName() {
        return name.getName();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable())
            moveDistance.move();
    }

    public boolean isSamePosition(int winnerPosition) {
        return this.getPosition() == winnerPosition;
    }

}
