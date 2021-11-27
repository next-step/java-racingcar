package step5.service;

import step5.dto.*;

public class RacingGameService {

    public static RacingGameService getInstance() {
        return RacingGameServiceHolder.INSTANCE;
    }

    public RaceRecordGroup raceStart(CarNames carNames, TrialCount trialCount) {
        RaceRecordGroup raceRecordGroup = new RaceRecordGroup();

        RacingCars racingCars = new RacingCars(carNames);
        RunStrategy runStrategy = new RandomStrategy();

        while(!trialCount.isFinalTrial()) {
            racingCars.moveRacingCars(runStrategy);

            raceRecordGroup.addRaceRecord(new RaceRecord(racingCars.currentCars()));

            trialCount.minusTrial();
        }

        return raceRecordGroup;
    }

    private static class RacingGameServiceHolder {
        static RacingGameService INSTANCE = new RacingGameService();
    }
}
