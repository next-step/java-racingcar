package racing;

import racing.domain.Cars;
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
        RacingCarGame racingCarGame = new RacingCarGame(nameOfCars, carMoveStrategy);

        ResultView resultView = ResultView.getInstance();
        Cars cars = racingCarGame.getCars();
        resultView.startPrint();
        for (int i = 0; i < numMoves; i++) {
            racingCarGame.run(numMoves);
            resultView.printRound(cars);
        }
        resultView.printWinner(racingCarGame.getWinner());
    }
}

