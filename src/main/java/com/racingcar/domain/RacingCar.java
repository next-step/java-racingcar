package com.racingcar.domain;

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

    public void setRacingCarMoveStrategy(RacingCarMoveStrategy racingCarMoveStrategy) {
        this.racingCarMoveStrategy = racingCarMoveStrategy;
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
