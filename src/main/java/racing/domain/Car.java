package racing.domain;

public class Car {

    private int moved;

    public Car() {
        this.moved = 0;
    }

    public int getMoved() {
        return moved;
    }

    public void move(MovableStrategy movableStrategy) {
        moved += movableStrategy.randomMovable();
    }

}
