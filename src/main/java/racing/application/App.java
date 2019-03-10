package racing.application;

import racing.ui.Before;
import racing.ui.Console;
import racing.view.RacingRequestView;

public class App {

    public static void main(String[] args) {
        RacingRequestView request = Before.set();

        RacingGame game = new RacingGame(request);
        Console.preView(game.getView());

        for (int i = 0; i < game.getTime(); i++) {
            game.run();
            Console.resultView(game.getView());
        }
    }
}
