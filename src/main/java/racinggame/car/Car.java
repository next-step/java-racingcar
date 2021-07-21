package racinggame.car;

import racinggame.strategy.MovingStrategy;

public class Car {

    private static final int STARTING_POSITION = 0;
    private final RacingRecord racingRecord;
    private int position;

    public Car() {
        position = STARTING_POSITION;
        racingRecord = new RacingRecord();
    }

    public void race(MovingStrategy strategy) {
        if (strategy.isMove()) {
            position++;
        }
        racingRecord.gameRecord(position);
    }

    public int getPosition() {
        return position;
    }

    public RacingRecord getRacingStatus() {
        return racingRecord;
    }
}
