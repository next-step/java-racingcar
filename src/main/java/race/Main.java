package race;

import race.view.InputView;
import race.view.OutputView;

public class Main {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(new OutputView(), new InputView());
        game.start();
    }

}
