package racing.controller;

import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;
import racing.domain.dto.GameRequest;
import racing.domain.RacingGame;
import racing.domain.Turn;
import racing.exception.InvalidInputException;
import racing.view.ResultView;

public class RacingController {
    private ResultView resultView;

    public RacingController(ResultView resultView) {
        this.resultView = resultView;
    }

    public void gameRun(GameRequest gameRequest) {
        if (!gameRequest.hasTurn()) {
            throw new InvalidInputException("진행할 턴이 없습니다.");
        }
        Fuel fuel = new RandomFuel();
        RacingGame game = new RacingGame(gameRequest.cars());

        Turn result = null;
        for (int i = 0; i < gameRequest.turnSize(); i++) {
            result = game.racing(fuel);
            resultView.printTurn(result);
        }
        resultView.printResultTitle();
        resultView.printWinners(result);
    }
}
