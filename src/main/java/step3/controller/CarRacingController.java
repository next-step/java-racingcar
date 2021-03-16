package step3.controller;

import step3.domain.CarRacing;
import step3.domain.CarRacingResult;
import step3.domain.Round;
import step3.view.InputView;

import java.util.List;

public class CarRacingController {
    private CarRacing carRacing;

    public CarRacingController(InputView inputView) {
        this.carRacing = new CarRacing(inputView.getCarsName(), new Round(inputView.getRoundsCount()));
    }

    public List<CarRacingResult> startCarRacing() {
        return this.carRacing.start();
    }

}
