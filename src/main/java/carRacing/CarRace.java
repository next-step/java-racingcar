package carRacing;

import carRacing.ui.InputView;

public class CarRace {
    public static void main(String[] args) {
        RacingGame game = new RacingGame(InputView.inputCarCount(), InputView.inputTrialCount());
        game.gameStart();
    }
}