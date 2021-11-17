package com.rick.racing.controller;

import com.rick.racing.model.CarRacingInfo;
import com.rick.racing.ui.ResultView;

public class CarRacingController {

    private final CarRacingInfo racingPlayData;
    private final CarMovingDecider carMovingDecider;

    private CarRacingController(CarRacingInfo racingPlayData, CarMovingDecider carMovingDecider) {
        this.racingPlayData = racingPlayData;
        this.carMovingDecider = carMovingDecider;
    }

    public static CarRacingController create(CarRacingInfo racingPlayData, CarMovingDecider carMovingDecider) {
        return new CarRacingController(racingPlayData, carMovingDecider);
    }

    public void start() {
        ResultView.drawRunResultMessage();
        for (int i = 0; i < racingPlayData.tryCount(); i++) {
            racingPlayData.cars()
                .forEach(carMovingDecider::move);

            ResultView.drawRoundResult(racingPlayData);
        }
        ResultView.drawWinner(racingPlayData);
    }
}
