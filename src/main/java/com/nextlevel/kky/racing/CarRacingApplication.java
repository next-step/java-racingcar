package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.CarNameValidator;
import com.nextlevel.kky.racing.core.CarRacingExecutor;
import com.nextlevel.kky.racing.ui.InputView;
import com.nextlevel.kky.racing.ui.ResultView;

public class CarRacingApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        if(!CarNameValidator.checkValidation(carNames)) {
            System.out.println("유효하지 않은 이름 입니다!");
            return;
        }

        int roundCount = InputView.inputNumber("시도할 회수는 몇 회 인가요?");

        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(carNames);
        ResultView.printCarRacingResultWithName(carRacingExecutor);

        for (; roundCount > 0; roundCount--) {
            carRacingExecutor.proceedNextRound();
            ResultView.printCarRacingResultWithName(carRacingExecutor);
        }

        ResultView.printCarWinners(carRacingExecutor.getCurrentWinners());
    }
}
