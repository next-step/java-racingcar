package racingcar;

import racingcar.domain.Game;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;

public class App {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        String[] names = InputView.requestInputNames();
        int repeat = InputView.requestInputRepeat();

        Game game = new Game(names, repeat, new ConsoleResultView());
        game.start();
    }
}
