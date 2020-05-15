package com.racingcar.service;

import com.racingcar.model.RacingCar;

import java.util.Random;

public class DefaultRacingCarRule implements RacingCarPlayRule {

    private static Integer RACING_CAR_MOVE_CONDITION_VALUE = 4;
    private static Integer RACING_CAR_STATUS_ADDING_VALUE = 1;
    private static Integer RANDOM_DICE_VALUE = 10;

    @Override
    public void moveRacingCar(RacingCar racingCar) {

        Integer randomStatusValue = generateRandomRacingStatusValue();

        if (randomStatusValue >= RACING_CAR_MOVE_CONDITION_VALUE) {
            racingCar.addRacingStatus(RACING_CAR_STATUS_ADDING_VALUE);
        }
    }

    protected Integer generateRandomRacingStatusValue() {
        Random randomRacingStatusValue = new Random();
        return randomRacingStatusValue.nextInt(RANDOM_DICE_VALUE);
    }
}
