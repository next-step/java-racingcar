package stage4.service;

import stage4.domain.*;

public class CarService {

    public Cars startRace(String[] carNames, int numberOfTries) {
        final Cars cars = new Cars(carNames);

        Cars results = new Cars();
        for (int i = 0; i < numberOfTries; i++) {
            results.addCars(cars.tryRacing());
        }
        return results;
    }

    public Cars checkWinner(Cars lastRacingResults) {
        return lastRacingResults.findWinners();
    }
}