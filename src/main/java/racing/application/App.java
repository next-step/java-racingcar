package racing.application;

import racing.infrastructure.RandomGame;
import racing.ui.GameReady;
import racing.ui.GameConsole;
import racing.view.RacingRequestView;

public class App {

    public static void main(String[] args) {
        RacingRequestView request = GameReady.set();

        RacingGame game = new RacingGame(request);
        GameConsole.preView(game.getView());

        game.start(new RandomGame());

        GameConsole.resultViews(game.getHistory());
    }
}
