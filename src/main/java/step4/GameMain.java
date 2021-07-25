package step4;

import step4.observers.RacingStatusByCarWithWinnerView;

public class GameMain {
    public static void main(String[] args) {
        RacingGameConfiguration racingGameConfiguration = RacingGameInputView.getRacingGameConfigurationWithPrompt();

        RacingGame racingGame = new RacingGame(racingGameConfiguration);
        // racingGame.attach(new SimpleRacingStatusView());
        racingGame.attach(new RacingStatusByCarWithWinnerView());

        racingGame.startGame();
    }
}
