package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.CarRacingExecutor;
import com.nextlevel.kky.racing.ui.InputView;
import com.nextlevel.kky.racing.ui.ResultView;

public class CarRacingApplication {

    public static void main(String[] args) {
        int carCount = InputView.inputNumber("자동차 대수는 몇 대 인가요?");
        int roundCount = InputView.inputNumber("시도할 회수는 몇 회 인가요?");

        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(carCount);

        for (; roundCount > 0; roundCount--) {
            ResultView.printCarRacingResult(carRacingExecutor);
            carRacingExecutor.proceedNextRound();
        }
    }
}
