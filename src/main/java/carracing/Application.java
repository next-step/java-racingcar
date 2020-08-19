package carracing;

import carracing.domain.Game;
import carracing.view.InputView;

public class Application {
    public static void main(String arg[]) {
        System.out.println("==== start car racing ====");
        InputView inputView = new InputView();
        Game game = new Game(inputView.getInputCarNames(), inputView.getInputTryCount());
        game.start();
        game.end();
    }
}