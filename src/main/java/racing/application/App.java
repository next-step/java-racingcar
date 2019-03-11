package racing.application;

import racing.ui.GameReady;
import racing.ui.GameConsole;
import racing.view.RacingRequestView;

public class App {

    public static void main(String[] args) {
        RacingRequestView request = GameReady.set();

        RacingGame game = new RacingGame(request);
        GameConsole.preView(game.getView());

        for (int i = 0; i < game.getTime(); i++) {
            game.start();
            GameConsole.resultView(game.getView());
        }
    }
}
