package step3;

import step3.view.ResultView;

public class CarRacingController {

    private CarRacing carRacing;

    public CarRacingController(int carNumbers, MoveStrategy moveStrategy) {
        this.carRacing = new CarRacing(carNumbers, moveStrategy);
    }

    public void racingStart(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            carRacing.moveCars();
            ResultView.displayCurrentCarsLocation(carRacing.getCars());
        }
    }
}
