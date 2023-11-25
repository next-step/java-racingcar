package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.dto.RacingInputDTO;
import racinggame.dto.RacingResultDTO;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class CarGameController {

    private static CarGameController instance;
    public static CarGameController getInstance() {
        if(instance == null) {
            instance = new CarGameController();
        }
        return instance;
    }

    public void playGame() {
        RacingInputDTO racingInputDTO = InputView.printRequestGameValue();
        RacingResultDTO racingResultDTO = new RacingGame().start(racingInputDTO);
        ResultView.printResult(racingResultDTO);
    }
}
