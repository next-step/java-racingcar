package game.model;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position(0);
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isPossibleToMove()) {
            this.position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }
}
