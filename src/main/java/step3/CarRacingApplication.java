package step3;

import step3.controller.CarRacingController;
import step3.view.InputView;
import step3.view.InputViewImpl;

public class CarRacingApplication {
    public static void main(String[] args) {
        CarRacingController carRacingController = new CarRacingController();
        InputView inputView = new InputViewImpl();

        carRacingController.racingGame(inputView.askNumberOfCars(), inputView.askNumberOfTrys());
    }
}
