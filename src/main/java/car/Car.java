package car;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.movable()) {
            position++;
        }
    }
}
