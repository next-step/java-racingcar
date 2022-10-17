package com.nextlevel.kky.racing.service;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarRacingExecutor;
import com.nextlevel.kky.racing.core.RandomIntegerGenerator;
import com.nextlevel.kky.racing.dto.CarRaceResultDto;
import com.nextlevel.kky.racing.dto.CarRaceResultDto.CarPositionDto;
import com.nextlevel.kky.racing.dto.CarRaceResultDto.RoundResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingService {

    private final CarCreateService carCreateService;

    public CarRacingService() {
        this.carCreateService = new CarCreateService(new RandomIntegerGenerator());
    }

    public CarRaceResultDto race(String[] carNames, int roundCount) {
        List<Car> carList = carCreateService.create(carNames);
        List<RoundResultDto> roundResultDtoList = new ArrayList<>();

        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(carList);
        roundResultDtoList.add(getCurrentStatus(carRacingExecutor));

        for (; roundCount > 0; roundCount--) {
            carRacingExecutor.proceedNextRound();
            roundResultDtoList.add(getCurrentStatus(carRacingExecutor));
        }

        return new CarRaceResultDto(roundResultDtoList, carRacingExecutor.getCurrentWinners());
    }

    private RoundResultDto getCurrentStatus(CarRacingExecutor carRacingExecutor) {
        List<CarPositionDto> carPositionDtoList = carRacingExecutor.getCarList().stream()
                .map(car -> new CarPositionDto(car.getName(), car.getCurrentPosition()))
                .collect(Collectors.toList());

        return new RoundResultDto(carPositionDtoList);
    }
}
