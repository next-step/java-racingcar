package step3;

import java.util.List;

public class CarRacingController {
    private CarRacing carRacing;

    public CarRacingController(InputView inputView) {
        this.carRacing = new CarRacing(inputView.getCarsName(), new Round(inputView.getRoundsCount()));
    }

    public List<CarResultDto> startCarRacing() {
        return this.carRacing.start();
    }

}
