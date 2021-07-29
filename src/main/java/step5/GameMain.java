package step5;

import step5.observers.RacingStatusByCarWithWinnerView;

public class GameMain {
    public static void main(String[] args) {
        RacingGameConfiguration racingGameConfiguration = RacingGameInputView.getRacingGameConfigurationWithPrompt();

        RacingGame racingGame = new RacingGame(racingGameConfiguration);
        racingGame.attach(new RacingStatusByCarWithWinnerView());

        racingGame.startGame();
    }
}
