package racingcar.controller;

import racingcar.domain.GameInputData;
import racingcar.service.RacingGameService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarResultView;

public class RacingCarController {

    private final RacingCarInputView inputView;

    public RacingCarController(RacingCarInputView inputView) {

        this.inputView = inputView;
    }

    public void execute() {

        GameInputData racingCarInput = inputView.getRacingCarInput();
        RacingGameService gameStart =
                RacingGameService.ready(racingCarInput.getCarNames(), racingCarInput.getTryCount());

        RacingCarResultView resultView = new RacingCarResultView();

        while(!gameStart.isEndGame()) {
            gameStart.race();
            resultView.print(gameStart.getCars());
        }
        resultView.printVictoryUser(gameStart.getCars().getVictoryUsers());
    }
}
