package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Tracker;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new InputView(), new ResultView(), new Random(), new Tracker());
        game.start();
        game.finish();
    }
}
