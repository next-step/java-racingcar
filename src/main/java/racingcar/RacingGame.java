package racingcar;

import racingcar.collection.RacingCarList;
import racingcar.collection.RacingResult;

public class RacingGame {
    private final RacingCarList carList = new RacingCarList();

    public RacingGame(int countOfCar) {
        for(int i=0; i<countOfCar; i++) {
            carList.participate(new Car());
        }
    }

    public RacingResult race() {
        return carList.moveAll();
    }
}
