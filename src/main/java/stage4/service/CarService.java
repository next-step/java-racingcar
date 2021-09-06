package stage4.service;

import stage4.domain.*;

public class CarService {

    public Cars startRace(String[] carNames, int numberOfTries) {
        final Cars targetCars = new Cars(carNames);

        Cars resultCars = new Cars();
        for (int i = 0; i < numberOfTries; i++) {
            final Cars racingResult = targetCars.tryRacing(new RandomMovableStrategy());
            resultCars.addCars(racingResult);
        }
        return resultCars;
    }

    public Cars checkWinner(Cars lastRacingResults) {
        return lastRacingResults.findWinners();
    }
}