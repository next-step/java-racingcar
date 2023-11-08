package carracing;

import carracing.dto.CarRaceResponse;
import carracing.ui.InputView;
import carracing.ui.OutputView;

public class CarRaceApplication {
    public static void main(String[] args) {
        CarRaceService carRaceService = new CarRaceService();

        InputView inputView = InputView.input();

        CarRaceResponse response = carRaceService.race(inputView.toRequest());

        OutputView.output(response);
    }
}
