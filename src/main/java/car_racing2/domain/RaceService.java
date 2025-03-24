package car_racing2.domain;

import car_racing2.domain.model.Cars;
import car_racing2.domain.model.RaceResult;
import car_racing2.view.InputData;

public class RaceService {
    public RaceResult race(InputData raceData) {
        Cars cars = new Cars(raceData.getCarNames(), new RandomMovingStrategy());
        RaceResult raceResult = new RaceResult();

        for (int i = 0; i < raceData.getNumOfRounds(); i++) {
            cars.moveAll();
            raceResult.recordResultOfRound(cars.getPositionsOfCars());
        }
        raceResult.recordRaceWinners(cars.getWinners());

        return raceResult;
    }
}
