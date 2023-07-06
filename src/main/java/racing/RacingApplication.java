package racing;

import racing.controller.GameController;
import racing.io.GameReader;
import racing.io.GameViewer;
import racing.model.Cars;
import racing.model.GameReadyInfo;

public class RacingApplication {

    public static void main(final String[] args) {
        final GameController gameController = new GameController(new GameViewer());
        final GameReadyInfo gameReadyInfo = readyGame();
        final Cars cars = new Cars(gameReadyInfo.getCars());
        gameController.startRacing(cars, gameReadyInfo.getTryCount());
    }

    private static GameReadyInfo readyGame() {
        final GameReader gameReader = new GameReader();
        return gameReader.readyGame();
    }
}
