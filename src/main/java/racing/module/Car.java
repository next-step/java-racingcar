package racing.module;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private int position;

    public Car() {
        this(DEFAULT_POSITION);
    }

    public Car(int position) {
        this.position = position;
    }

    public void attempt(MoveStrategy strategy) {
        if (strategy.canMove()) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
