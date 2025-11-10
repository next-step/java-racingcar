package study.racing.domain;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int randonValue) {
        if (randonValue >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
