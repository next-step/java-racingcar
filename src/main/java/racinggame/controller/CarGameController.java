package racinggame.controller;

import racinggame.dto.RacingInputDTO;
import racinggame.dto.RacingResultDTO;
import racinggame.service.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class CarGameController {

    private static CarGameController instance;

    public static CarGameController getInstance() {
        if (instance == null) {
            instance = new CarGameController();
        }
        return instance;
    }

    public void playGame() {
        try {
            RacingInputDTO racingInputDTO = InputView.printRequestGameValue();
            RacingResultDTO racingResultDTO = RacingGame.start(racingInputDTO);
            ResultView.printResult(racingResultDTO);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            playGame();
        }
    }
}
