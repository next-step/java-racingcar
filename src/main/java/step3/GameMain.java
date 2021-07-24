package step3;

import step3.observers.SimpleRacingStatusView;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        RacingGameConfiguration racingGameConfiguration =
                new RacingGameInputView().getRacingGameConfigurationWithPrompt();

        RacingGame racingGame = new RacingGame(racingGameConfiguration);
        racingGame.attach(new SimpleRacingStatusView());

        racingGame.startGame();
    }
}
