package car_racing.domain;

import car_racing.domain.model.Cars;
import car_racing.view.CarPrinter;
import car_racing.view.model.UserInput;

public class CarController {
    private final Cars cars;
    private final UserInput userInput;

    public CarController(UserInput userInput) {
        this.userInput = userInput;
        this.cars = new Cars(userInput.getNumOfCar());
    }

    public void race() {
        showRaceStart();
        for (int i = 0; i < userInput.getNumOfGame(); i++) {
            cars.moveAll();
            showRaceResult();
        }
    }

    private void showRaceStart() {
        CarPrinter.showRaceStart();
    }

    private void showRaceResult() {
        CarPrinter.showRaceResult(cars);
    }
}
