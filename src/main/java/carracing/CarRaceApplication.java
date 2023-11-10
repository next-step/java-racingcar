package carracing;

import carracing.ui.InputView;
import carracing.ui.dto.CarRaceResponse;
import carracing.utils.config.CarRaceConfig;

import static carracing.ui.InputView.input;
import static carracing.ui.OutputView.output;

public class CarRaceApplication {
    public static void main(String[] args) {
        CarRaceConfig carRaceConfig = new CarRaceConfig();
        CarRaceService carRaceService = carRaceConfig.getCarRaceService();

        InputView inputView = input();

        CarRaceResponse response = carRaceService.race(inputView.toRequest());

        output(response);
    }
}
