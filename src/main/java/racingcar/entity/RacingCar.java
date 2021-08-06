package racingcar.entity;


import racingcar.strategy.MoveStrategy;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;

    private final Name name;
    private int position;

    public RacingCar(Name carName) {
        this.name = carName;
        this.position = BASE_POSITION;
    }

    public void moveIfMovable(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable())
            position += ONE_STEP;
    }

    public int ifBiggerThanReturnPosition(int maxPosition){
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }
    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePositionAs(int winnerRecord) {
        return position == winnerRecord;
    }
}
