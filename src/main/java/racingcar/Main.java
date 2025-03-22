package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Tracker;
import racingcar.domain.movingstrategy.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new InputView(), new ResultView(), new Tracker(), new RandomStrategy());
        game.start();
        game.finish();
    }
}
