package racing.model;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
