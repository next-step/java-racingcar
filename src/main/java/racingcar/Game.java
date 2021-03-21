package racingcar;

import racingcar.domain.Records;
import racingcar.service.GameService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Game {

    public static void main(String[] args) {
        GameService gameService = new RacingGameService();

        String carNames = InputView.getCarNames();
        int stepNumber = InputView.getStepNumber();


        gameService.init(carNames, stepNumber);
        Records records = gameService.run();

        ResultView.printRecords(records);
        
    }


}