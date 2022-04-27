package racing;

import racing.domain.RacingHistories;
import racing.domain.strategies.CarMoveStrategy;
import racing.domain.strategies.CarMoveStrategyImpl;
import racing.domain.strategies.CustomRandomImpl;
import racing.service.RacingCarGame;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        List<String> nameOfCars = inputView.getNameOfCars();
        int numMoves = inputView.getNumMoves();

        CarMoveStrategy carMoveStrategy = new CarMoveStrategyImpl(new CustomRandomImpl());
        RacingCarGame racingCarGame = new RacingCarGame();

        ResultView resultView = ResultView.getInstance();
        RacingHistories racingHistories = racingCarGame.run(numMoves, nameOfCars, carMoveStrategy);
        resultView.showProgress(racingHistories);
        resultView.showWinner(racingHistories.getWinners());
    }
}

