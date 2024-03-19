package step5.controller;

import step5.domain.Racing;
import step5.domain.car.move.random.RandomCreator;
import step5.domain.car.move.random.RandomMoveStrategy;
import step5.view.InputRequest;
import step5.view.InputView;
import step5.view.ResultView;

public class CarController {
    private final static RandomCreator RANDOM_CREATOR = new RandomCreator();

    public void startGame() {
        InputRequest inputRequest = InputView.createInputRequest();
        ResultView resultView = new ResultView(Racing.createRacing(inputRequest.getCarNames(), inputRequest.getTryNumber(), createCarRandomMoveStrategy()));
        resultView.startGame();
    }

    private static RandomMoveStrategy createCarRandomMoveStrategy() {
        return new RandomMoveStrategy(RANDOM_CREATOR);
    }
}
