package racingcar;

import racingcar.car.CarManager;
import racingcar.common.util.InputUtils;

public class RacingManager {
    public static void main(String[] args) {
        int carCount = InputUtils.getIntValue("자동차 대수는 몇 대 인가요?");
        int repeatCount = InputUtils.getIntValue("시도할 회수는 몇 회 인가요?");

        CarManager carManager = new CarManager(carCount, repeatCount);
        carManager.startRace();
    }
}
