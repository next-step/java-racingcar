package com.racingcar.model;

import com.racingcar.service.DefaultRacingCarRule;
import com.racingcar.service.RacingCarMoveStrategy;

public class RacingCar {

    private Integer racingStatus;
    private RacingCarMoveStrategy racingCarMoveStrategy;

    public RacingCar(Integer racingStatus) {
        this.racingStatus = racingStatus;
        this.racingCarMoveStrategy = new DefaultRacingCarRule();
    }

    public Integer getRacingStatus() {
        return racingStatus;
    }

    public void movingRacingCar() {
        if (racingCarMoveStrategy.isRacingCarMove()) {
            this.racingStatus += racingCarMoveStrategy.getMovingDistance();
        }
    }
}
