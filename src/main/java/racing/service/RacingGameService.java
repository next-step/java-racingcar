package racing.service;

import racing.domain.*;

public class RacingGameService {
    public Cars generateCar(String[] carNames) {
        Cars cars = new Cars();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public RaceResult race(String[] names, int count) {
        Cars cars = generateCar(names);
        RacingRecord racingRecord = new RacingRecord();

        for (int i = 0; i < count; i++) {
            raceStep(cars);
            racingRecord.addAll(cars.getLapTime());
        }

        return new RaceResult(racingRecord, new RacingWinners(cars.getWinners()));
    }

    private void raceStep(Cars cars) {
        cars.race();
    }
}
