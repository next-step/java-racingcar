package carracing;

import carracing.ui.InputView;

public class CarRace {
    public static void main(String[] args) {
        RacingGame game = new RacingGame(InputView.inputGiveCarName(), InputView.inputTrialCount());
        game.gameStart();
    }
}