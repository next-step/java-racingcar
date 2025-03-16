package car_racing.domain.service;

import car_racing.domain.strategy.CarMovingStrategy;
import car_racing.domain.model.Cars;
import car_racing.view.service.PrintService;
import car_racing.view.model.UserInput;

public class RaceService {
    public void race(UserInput userInput, CarMovingStrategy carMovingStrategy) {
        Cars cars = new Cars(userInput.getNumOfCar(), carMovingStrategy);

        showRaceStart();
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            playRound(cars);
        }
    }

    private void playRound(Cars cars) {
        cars.moveAll();
        showRaceResult(cars);
    }

    private void showRaceStart() {
        PrintService.showRaceStart();
    }

    private void showRaceResult(Cars cars) {
        PrintService.showRaceResult(cars);
    }
}
