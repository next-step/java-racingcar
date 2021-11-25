package com.rick.racing.controller;

import com.rick.racing.domain.CarRacingInfo;
import com.rick.racing.view.ResultView;

public class CarRacingController {

    private final CarRacingInfo racingPlayInfo;
    private final CarMovingStrategy carMovingStrategy;

    private CarRacingController(final CarRacingInfo racingPlayData, final CarMovingStrategy carMovingStrategy) {
        this.racingPlayInfo = racingPlayData;
        this.carMovingStrategy = carMovingStrategy;
    }

    public static CarRacingController create(final CarRacingInfo racingPlayData, final CarMovingStrategy carMovingStrategy) {
        return new CarRacingController(racingPlayData, carMovingStrategy);
    }

    public void start() {
        ResultView.drawRunResultMessage();

        while (racingPlayInfo.isEnd()) {
            racingPlayInfo.doRound(carMovingStrategy);
            ResultView.drawRoundResult(racingPlayInfo.getCarGroup());
        }
        ResultView.drawWinner(racingPlayInfo);
    }
}
