package com.rick.racing.controller;

import com.rick.racing.model.CarRacingInfo;
import com.rick.racing.ui.ResultView;

public class CarRacingController {

    private final CarRacingInfo racingPlayData;
    private final CarMovingStrategy carMovingStrategy;

    private CarRacingController(final CarRacingInfo racingPlayData, final CarMovingStrategy carMovingStrategy) {
        this.racingPlayData = racingPlayData;
        this.carMovingStrategy = carMovingStrategy;
    }

    public static CarRacingController create(final CarRacingInfo racingPlayData, final CarMovingStrategy carMovingStrategy) {
        return new CarRacingController(racingPlayData, carMovingStrategy);
    }

    public void start() {
        ResultView.drawRunResultMessage();

        int tryCount = racingPlayData.getTryCount()
            .asInt();

        for (int i = 0; i < tryCount; i++) {
            racingPlayData.getCarGroup()
                .doRound(carMovingStrategy);

            ResultView.drawRoundResult(racingPlayData);
        }
        ResultView.drawWinner(racingPlayData);
    }
}
