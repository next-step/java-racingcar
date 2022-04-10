package racing;

import racing.model.CarMoveStrategy;
import racing.model.CarMoveStrategyImpl;
import racing.model.CustomRandomImpl;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numCars = inputView.getNumCars();
        int numMoves = inputView.getNumMoves();

        CarMoveStrategy carMoveStrategy = new CarMoveStrategyImpl(new CustomRandomImpl());
        RacingCarGame racingCarGame = new RacingCarGame(numCars, carMoveStrategy);
        GameResult result = racingCarGame.run(numMoves);

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}

