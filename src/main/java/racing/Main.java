package racing;

import racing.controller.RacingController;
import racing.domain.Cars;
import racing.domain.GameRule;
import racing.domain.RacingGame;
import racing.domain.RandomGameRule;
import racing.view.InputDto;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputDto inputDto = RacingController.putGameConfig();
        GameRule rule = new RandomGameRule();
        RacingGame game = RacingController.create(inputDto, rule);

        List<Cars> results = RacingController.play(game);
        List<String> winners = RacingController.winners(game);

        ResultView.printCarsLocations(results);
        ResultView.printWinners(winners);
    }
}
