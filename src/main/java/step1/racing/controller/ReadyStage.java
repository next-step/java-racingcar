package step1.racing.controller;

import step1.racing.RacingGame;
import step1.racing.common.TerminalInput;
import step1.racing.data.GameCount;
import step1.racing.view.CarPositionViewer;

public class ReadyStage {
    private final RacingGame racingGame;
    private final GameCount gameCount;

    public ReadyStage() {
        this.racingGame = GameGenerator.getRacingGame();
        this.gameCount = new GameCount(TerminalInput.readInt("플레이 횟수 입력 : "));
    }

    public void play() {
        while (gameCount.isPlayable()) {
            CarPositionViewer.printStatus(racingGame.move(), "진행 상황");
        }
        CarPositionViewer.printWinner(racingGame, "우승자");
    }
}
