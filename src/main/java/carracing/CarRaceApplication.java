package carracing;

import carracing.ui.InputView;
import carracing.ui.dto.CarRaceResponse;

import static carracing.ui.InputView.input;
import static carracing.ui.OutputView.output;
import static carracing.utils.config.CarRaceFactory.carRaceService;
import static carracing.utils.config.CarRaceFactory.init;

public class CarRaceApplication {
    public static void main(String[] args) {
        init();
        InputView inputView = input();

        CarRaceResponse response = carRaceService.race(inputView.toRequest());

        output(response);
    }
}
