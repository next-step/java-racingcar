package racingcar.car;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private static final int MOVABLE_CONDITION = 4;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public int move(int random) {
        if (random >= MOVABLE_CONDITION) {
            return ++this.position;
        }
        return this.position;
    }

    public int getPosition() {
        return this.position;
    }
}
