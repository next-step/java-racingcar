package racing;

import racing.service.RaceService;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RaceService raceService = new RaceService(InputView.getCarName(), InputView.getMoveCount());

        OutputView.printResultLabel();
        while (!raceService.gameEnd()) {
            raceService.race();
            OutputView.printResult(raceService.getCars());
        }
        OutputView.printWinner(raceService.getWinners());
    }
}
