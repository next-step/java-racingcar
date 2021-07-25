package race;

import race.view.InputView;
import race.view.ResultView;

public class Game {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void play() {
        Condition condition = this.prepare();
        Cars cars = Cars.of(condition);
        cars.moveAll();
        terminate(cars, condition);
    }

    private Condition prepare() {
        return inputView.operate();
    }

    private void terminate(Cars cars, Condition condition) {
        resultView.operate(cars, condition.getTryCount());
    }

}
