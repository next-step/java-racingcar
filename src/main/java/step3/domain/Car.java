package step3.domain;

public class Car {

    private int moveDistance = 0;

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable())
            moveDistance++;
    }

    public int getPosition() {
        return moveDistance;
    }
}
