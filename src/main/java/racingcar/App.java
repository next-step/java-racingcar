package racingcar;

import racingcar.domain.Game;
import racingcar.listener.ConsoleGameEventListener;
import racingcar.view.InputView;

public class App {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        String[] names = InputView.requestInputNames();
        int repeat = InputView.requestInputRepeat();

        Game game = new Game(names, repeat, new ConsoleGameEventListener());
        game.start();
    }
}
