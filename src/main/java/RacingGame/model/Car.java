package RacingGame.model;

public class Car {
    private static final int DEFAULT_MOVE_DISTANCE = 1;
    private int position;

    public Car() {
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void move(MovableStrategy strategy) {
        if (isMoveCar(strategy)) {
            move();
        }
    }

    private void move() {
        position += DEFAULT_MOVE_DISTANCE;
    }

    private static boolean isMoveCar(MovableStrategy strategy) {
        return strategy.movable();
    }
}