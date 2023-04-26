package racing;

import racing.controller.RacingController;
import racing.domain.Cars;
import racing.domain.RacingGame;
import racing.view.InputDto;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputDto inputDto = RacingController.putGameConfig();
        RacingGame game = RacingController.create(inputDto);

        List<Cars> results = RacingController.play(game);
        List<String> winners = RacingController.winners(game);

        ResultView.printCarsLocations(results);
        ResultView.printWinners(winners);
    }
}
