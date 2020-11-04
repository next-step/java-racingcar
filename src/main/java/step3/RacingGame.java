package step3;

import step3.strategy.MoveStrategy;

public class RacingGame {

    private MoveStrategy moveStrategy;
    private RacingCarList racingCarList;

    public RacingGame(int carCount, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new NullPointerException(ErrorMessage.MOVE_STRATEGY_IS_NULL);
        }
        this.moveStrategy = moveStrategy;
        this.racingCarList = new RacingCarList(carCount);
    }

    public void playStep() {
        racingCarList.moveCars(moveStrategy);
    }

    public RacingCarList getRacingCarList() {
        return racingCarList;
    }

}
