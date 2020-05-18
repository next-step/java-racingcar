package com.racingcar.model;

import com.racingcar.service.RacingCarMoveStrategy;
import com.racingcar.service.RacingCarRule;

public class RacingCar {

    private Integer racingStatus;
    private String racingCarName;
    private RacingCarMoveStrategy racingCarMoveStrategy;

    public RacingCar(Integer racingStatus) {
        this.racingStatus = racingStatus;
        this.racingCarMoveStrategy = new RacingCarRule();
    }

    public RacingCar(Integer racingStatus, String racingCarName) {
        this.racingStatus = racingStatus;
        this.racingCarName = racingCarName;
        this.racingCarMoveStrategy = new RacingCarRule();
    }

    public void setRacingStatus(Integer racingStatus) {
        this.racingStatus = racingStatus;
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
