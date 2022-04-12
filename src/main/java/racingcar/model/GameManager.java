package racingcar.model;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class GameManager {

    private final InputView inputView;

    private final ResultView resultView;

    public GameManager() {
        this(new InputView(), new ResultView());
    }

    public GameManager(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Game game = generateGame();
        playGame(game);
        printWinner(game);

    }

    private void printWinner(Game game) {
        List<CarName> winners = game.getWinners();
        resultView.printWinners(winners);
    }

    private void playGame(Game game) {
        while (game.hasNextTrial()) {
            List<CarLocationResult> carLocationResults = game.play();
            resultView.printCurrentCarMovements(carLocationResults);
            game.increaseNextTrial();
        }
    }

    private Game generateGame() {
        Cars cars = new Cars(inputView.inputCars());
        TrialCount trialCount = inputView.inputTrialCount();
        return new Game(cars, trialCount);
    }

}
