package racing;

import racing.controller.GameController;
import racing.io.GameReader;
import racing.io.GameViewer;
import racing.model.GameReadyInfo;

public class RacingApplication {

    public static void main(final String[] args) {
        final GameController gameController = new GameController(new GameViewer());
        final GameReadyInfo gameReadyInfo = readyGame();
        gameController.startRacing(gameReadyInfo);
    }

    private static GameReadyInfo readyGame() {
        final GameReader gameReader = new GameReader();
        return gameReader.readyGame();
    }
}
