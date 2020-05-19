package com.racingcar.service;

import java.util.Random;

public class RacingCarRule implements RacingCarMoveStrategy {

    private static final Integer RACING_CAR_MOVE_CONDITION_VALUE = 4;
    private static final Integer RACING_CAR_STATUS_ADDING_VALUE = 1;
    private static final Integer RANDOM_DICE_VALUE = 10;

    @Override
    public Boolean isRacingCarMove() {

        Integer randomStatusValue = generateRandomRacingStatusValue();
        if (randomStatusValue >= RACING_CAR_MOVE_CONDITION_VALUE) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Integer getMovingDistance() {
        return RACING_CAR_STATUS_ADDING_VALUE;
    }

    protected Integer generateRandomRacingStatusValue() {
        Random randomRacingStatusValue = new Random();
        return randomRacingStatusValue.nextInt(RANDOM_DICE_VALUE);
    }
}
