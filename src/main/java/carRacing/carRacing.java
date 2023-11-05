package carRacing;

import carRacing.ui.InputView;

public class carRacing {
    public static void main(String[] args) {
        RacingGame game = new RacingGame(InputView.inputCarCount(), InputView.inputTrialCount());
        game.gameStart();
    }
}