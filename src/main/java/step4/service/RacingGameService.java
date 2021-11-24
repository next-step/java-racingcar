package step4.service;

import step4.dto.*;

import java.util.List;

public class RacingGameService {
    public RacingGameService() {}

    public RaceRecordGroup raceStart(List<String> carsName, TrialCount trialCount) {
        RaceRecordGroup raceRecordGroup = new RaceRecordGroup();

        RacingCars racingCars = new RacingCars(carsName);
        RunStrategy runStrategy = new RandomStrategy();

        while(!trialCount.isFinalTrial()) {
            racingCars.moveRacingCars(runStrategy);

            raceRecordGroup.addRaceRecord(new RaceRecord(racingCars.currentCars()));

            trialCount.minusTrial();
        }

        return raceRecordGroup;
    }
}
