package car_racing.domain;

import car_racing.domain.model.Cars;
import car_racing.view.PrintService;
import car_racing.view.model.UserInput;

public class RaceService {
    public void race(UserInput userInput) {
        Cars cars = new Cars(userInput.getNumOfCar());

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
