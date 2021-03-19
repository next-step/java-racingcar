package step3.controller;

import step3.domain.CarRacing;
import step3.domain.CarRacingResult;
import step3.domain.Cars;
import step3.domain.Round;
import step3.view.InputView;

public class CarRacingController {
    private final CarRacing carRacing;

    public CarRacingController(InputView inputView) {
        this.carRacing = new CarRacing(new Cars(inputView.getCarsName()), new Round(inputView.getRoundsCount()));
    }

    public CarRacingResult startCarRacing() {
        return this.carRacing.start();
    }

}
