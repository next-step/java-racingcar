package step3;

import step3.strategy.MoveStrategy;


public class RacingCarManager {

    private MoveStrategy moveStrategy;
    private RacingCarList racingCarList;

    public RacingCarManager(int carCount, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new NullPointerException(ErrorMessage.MOVE_STRATEGY_IS_NULL);
        }
        this.moveStrategy = moveStrategy;
        this.racingCarList = new RacingCarList(carCount);
    }

    public void moveCars() {
        racingCarList.moveCars(moveStrategy);
    }

    public RacingCarList getRacingCarList() {
        return racingCarList;
    }

}
