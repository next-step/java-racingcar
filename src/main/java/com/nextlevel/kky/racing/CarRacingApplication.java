package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.controller.CarRacingController;
import com.nextlevel.kky.racing.dto.CarRaceResultDto;
import com.nextlevel.kky.racing.ui.InputView;
import com.nextlevel.kky.racing.ui.ResultView;

public class CarRacingApplication {

    private static final CarRacingController carRacingController = new CarRacingController();

    public static void main(String[] args) {
        String[] carNames = InputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int roundCount = InputView.inputNumber("시도할 회수는 몇 회 인가요?");

        CarRaceResultDto carRaceResultDto = carRacingController.race(carNames, roundCount);

        ResultView.printCarRaceResultDto(carRaceResultDto);
    }
}
