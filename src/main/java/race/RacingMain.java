package race;

import static race.view.InputView.askAttemptCount;
import static race.view.InputView.askCarsNumber;

public class RacingMain {

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start(askCarsNumber(), askAttemptCount());
    }

}
