package step1.racing.controller;

import step1.racing.RacingGame;
import step1.racing.view.CarPositionViewer;

public class ReadyStage {
    private final RacingGame racingGame;

    public ReadyStage() {
        this.racingGame = GameGenerator.getRacingGame();
    }

    public void play() {
        CarPositionViewer.printStatus(racingGame);
        racingGame.move();
        CarPositionViewer.printStatus(racingGame);
        CarPositionViewer.printWinner(racingGame);
    }
}
