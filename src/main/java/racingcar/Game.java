package racingcar;

import racingcar.service.GameService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {

    public static void main(String[] args) {
        GameService gameService = new RacingGameService();

        int carNumber = InputView.getCarNumber();
        int stepNumber = InputView.getStepNumber();

        gameService.init(carNumber, stepNumber);
        ResultView.printStart();
        ResultView.printRecords(gameService.run());
    }
}