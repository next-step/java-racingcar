package racingcar.controller;

import racingcar.domain.GameInputData;
import racingcar.domain.value.Round;
import racingcar.service.RacingGameService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarResultView;

import java.util.List;

public class RacingCarController {

    private final RacingCarInputView inputView;

    public RacingCarController(RacingCarInputView inputView) {

        this.inputView = inputView;
    }

    public void execute() {

        GameInputData racingCarInput = inputView.getRacingCarInput();

        Round round = Round.from(racingCarInput.getTryCount());
        List<String> carName = racingCarInput.getCarNames();

        RacingGameService gameStart = RacingGameService.ready(carName, round);
        RacingCarResultView resultView = new RacingCarResultView();

        while(!gameStart.isEndGame()) {
            gameStart.race();
            resultView.print(gameStart.getCars());
        }
        resultView.printVictoryUser(gameStart.getCars().getVictoryUsers());
    }
}
