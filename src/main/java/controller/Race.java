package controller;

import domain.Cars;
import domain.RaceCondition;
import domain.RaceRecord;
import service.RunRace;


public class Race {
    private static final int CHECK_CAR_COUNT = 0;
    private final RaceRecord raceRecord = new RaceRecord();
    private final RaceCondition raceCondition = new RaceCondition();

    public RaceRecord start(String carsName, RunRace runRace) {
        Cars cars = Cars.builder()
                .carsName(carsName)
                .raceCondition(raceCondition)
                .build();

        if (cars.checkSize(CHECK_CAR_COUNT)) {
            throw new IllegalArgumentException("자동차 대수는 1대 이상이어야 경주 할 수 있습니다.");
        }

        return runRace.run(raceRecord, cars);
    }

}
