package racing;

public class Car {
    static final int MOVE_THRESHOLD = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void move(int diceValue) {
        if (diceValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
