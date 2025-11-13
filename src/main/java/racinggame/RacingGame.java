package racinggame;

import static racinggame.ui.MC.*;
import static racinggame.ui.MC.askCarNamesToUser;
import static racinggame.ui.ResultView.printCarPositionTitle;

import racinggame.car.Cars;
import racinggame.ui.MC;
import racinggame.ui.UserInput;

public class RacingGame {

    public void start() {
        UserInput userInput = getUserInput();
        int carCount = askCarNamesToUser();
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
