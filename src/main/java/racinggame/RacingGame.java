package racinggame;

import static racinggame.ui.MC.*;
import static racinggame.ui.MC.askCarCountToUser;
import static racinggame.ui.ResultView.printCarPositionTitle;

import racinggame.car.Cars;

public class RacingGame {

    public void start() {
        int carCount = askCarCountToUser();
        int tryCount = askTryCountToUser();

        Cars cars = Cars.of(carCount);
        startRacing(tryCount, cars);

    }

    private void startRacing(int tryCount, Cars cars) {
        printCarPositionTitle();
        for (int i = 0; i < tryCount; i++) {
            // 랜덤값 구하기
            cars.playPerRound();

            printGameStates(cars);
        }
    }
}
