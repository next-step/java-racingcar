package racingCar.domain;

public class Position {
    private static final int INITIAL_POSITION = 0;

    private int cur;

    public Position() {
        cur = INITIAL_POSITION;
    }

    public int getPosition() {
        return cur;
    }

    public void move(Condition condition) {
        if (condition.isGo()) {
            this.cur++;
        }
    }
}
