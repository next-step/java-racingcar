package racing.model;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private final int position;

    public Car(int position) {
        this.position = position;
    }

    public Car moved(int number) {
        if (canMove(number)) {
            return move();
        }
        return this;
    }

    public int getPosition() {
        return position;
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }

    private Car move() {
        return new Car(this.position + 1);
    }
}
