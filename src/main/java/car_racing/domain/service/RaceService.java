package car_racing.domain.service;

import car_racing.domain.model.RaceResultOfRound;
import car_racing.domain.model.RaceResults;
import car_racing.domain.strategy.CarMovingStrategy;
import car_racing.domain.model.Cars;
import car_racing.view.model.UserInput;

public class RaceService {
    public RaceResults race(UserInput userInput, CarMovingStrategy carMovingStrategy) {
        Cars cars = new Cars(userInput.getNamesOfCar(), carMovingStrategy);
        RaceResults raceResults = new RaceResults();

        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            cars.moveAll();
            raceResults.addRaceResult(new RaceResultOfRound(cars));
        }

        return raceResults;
    }
}
