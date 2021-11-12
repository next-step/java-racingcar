package carracingwinner;

import carracingwinner.domain.Cars;
import carracingwinner.domain.Rounds;
import carracingwinner.ui.InputView;
import carracingwinner.ui.ResultView;

public class CarRacingGame {

    private final InputView inputView;
    private final ResultView resultView;

    public CarRacingGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Cars cars = new Cars(inputView.readCarNames());
        Rounds rounds = new Rounds(inputView.readTryCount());

        rounds.playRounds(cars);

        resultView.printResults(rounds.getResults());
        resultView.printWinners(rounds.getLastWinners());
    }

}
