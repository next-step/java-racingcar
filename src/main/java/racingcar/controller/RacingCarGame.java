package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.cars.CarsService;
import racingcar.service.race.RaceService;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final CarsService carsService;
    private final RaceService raceService;

    public RacingCarGame(CarsService carsService, RaceService raceService) {
        this.carsService = carsService;
        this.raceService = raceService;
    }

    public void run() {

        List<String> carsName = carsService.getCarsName();
        List<Car> cars = carsName.stream()
                                 .map(Car::new)
                                 .collect(Collectors.toList());
        int raceTryCount = raceService.getRaceTryCount();
        raceService.raceStart(cars, raceTryCount);
    }
}
