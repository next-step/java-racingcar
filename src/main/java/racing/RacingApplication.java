package racing;

import racing.controller.RaceController;
import racing.model.CarsFactory;
import racing.view.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        String cars = InputView.readCarNameInput();
        int roundCount = InputView.readRoundCountInput();

        RaceController controller = new RaceController(CarsFactory.createCars(cars), roundCount);
        controller.start();
    }
}
