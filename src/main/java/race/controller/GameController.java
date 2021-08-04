package race.controller;

import race.domain.Cars;
import race.domain.Condition;
import race.domain.Game;
import race.view.InputView;
import race.view.ResultView;

public class GameController {

    private final InputView inputView = InputView.getInstance();
    private final ResultView resultView = ResultView.getInstance();

    public void run() {
        Condition condition = this.prepare();

        Game game = new Game(condition);
        game.play();

        Cars registeredCars = game.findRegisteredCars();
        this.terminate(registeredCars, condition);
    }

    private Condition prepare() {
        return inputView.operate();
    }

    private void terminate(Cars cars, Condition condition) {
        resultView.operate(cars, condition.getTryCount());
    }
}
