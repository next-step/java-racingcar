package com.nextlevel.kky.racing.controller;

import com.nextlevel.kky.racing.dto.CarRaceResultDto;
import com.nextlevel.kky.racing.service.CarRacingService;

public class CarRacingController {

    private final CarRacingService carRacingService = new CarRacingService();

    public CarRaceResultDto race(String[] carNames, int roundCount) {
        return carRacingService.race(carNames, roundCount);
    }
}
