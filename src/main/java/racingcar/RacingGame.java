package racingcar;

import racingcar.collection.RacingCarList;
import racingcar.collection.RacingResult;
import racingcar.strategy.RandomMoveStrategy;

public class RacingGame {
    private final RacingCarList carList = new RacingCarList();

    public RacingGame(int countOfCar) {
        for(int i=0; i<countOfCar; i++) {
            carList.participate(new Car(new RandomMoveStrategy()));
        }
    }

    public RacingResult race() {
        return carList.moveAll();
    }
}
