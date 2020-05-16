package com.racingcar.model;

import com.racingcar.service.DefaultRacingCarRule;
import com.racingcar.service.RacingCarMoveStrategy;

public class RacingCar {

    private Integer racingStatus;
    private String racingCarName;
    private RacingCarMoveStrategy racingCarMoveStrategy;

    public RacingCar(Integer racingStatus) {
        this.racingStatus = racingStatus;
        this.racingCarMoveStrategy = new DefaultRacingCarRule();
    }

    public RacingCar(Integer racingStatus, String racingCarName) {
        this.racingStatus = racingStatus;
        this.racingCarName = racingCarName;
        this.racingCarMoveStrategy = new DefaultRacingCarRule();
    }

    public Integer getRacingStatus() {
        return racingStatus;
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public void movingRacingCar() {
        if (racingCarMoveStrategy.isRacingCarMove()) {
            this.racingStatus += racingCarMoveStrategy.getMovingDistance();
        }
    }
}
