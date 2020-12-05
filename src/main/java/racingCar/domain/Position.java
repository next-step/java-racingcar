package racingCar.domain;

public class Position implements MoveStrategy {
    private static final int START_CONDITION = 4;
    private static final int END_CONDITION = 9;

    private int cur = 0;

    public int getPosition() {
        return cur;
    }

    @Override
    public void move(int value) {
        if(value >= START_CONDITION && value <= END_CONDITION) {
            this.cur++;
        }
    }
}
