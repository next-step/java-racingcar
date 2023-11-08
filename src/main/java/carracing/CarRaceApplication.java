package carracing;

import carracing.dto.CarRaceResponse;
import carracing.move_strategy.RandomMoveStopStrategy;
import carracing.ui.InputView;
import carracing.ui.OutputView;

public class CarRaceApplication {
    public static void main(String[] args) {
        CarRaceService carRaceService = new CarRaceService(new RandomMoveStopStrategy());

        InputView inputView = InputView.input();

        CarRaceResponse response = carRaceService.race(inputView.toRequest());

        OutputView.output(response);
    }
}
