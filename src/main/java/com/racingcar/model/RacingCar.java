package com.racingcar.model;

public class RacingCar {

    private Integer racingStatus;

    public RacingCar(Integer racingStatus) {
        this.racingStatus = racingStatus;
    }

    public Integer getRacingStatus() {
        return racingStatus;
    }

    public void addRacingStatus(Integer racingStatus) {
        this.racingStatus += racingStatus;
    }


}
