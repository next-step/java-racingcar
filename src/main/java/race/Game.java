package race;

import race.view.InputView;
import race.view.ResultView;

public class Game {

    InputView inputView = InputView.getInstance();
    ResultView resultView = ResultView.getInstance();

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    public void play() {
        Condition condition = this.prepare();
        Cars cars = Cars.of(condition);
        cars.playMaximumRound();
        terminate(cars, condition);
    }

    private Condition prepare() {
        return inputView.operate();
    }

    private void terminate(Cars cars, Condition condition) {
        resultView.operate(cars, condition.getTryCount());
    }

}
