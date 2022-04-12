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
        Cars cars = new Cars(inputView.inputCars());
        TrialCount trialCount = inputView.inputTrialCount();
        Game game = new Game(cars, trialCount, new MovementChecker());

        while (game.hasNextTrial()) {
            List<CarLocationResult> carLocationResults = game.play();
            resultView.printCurrentCarMovements(carLocationResults);
            game.increaseNextTrial();
        }
    }

}
