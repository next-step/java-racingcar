package step3.domain;

public class Car {

    private MoveDistance moveDistance;
    private Name name;

    public Car() {
        moveDistance = new MoveDistance();
        name = new Name("뿌리");
    }

    public int getPosition() {
        return moveDistance.getMoveDistance();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable())
            moveDistance.move();
    }

}
