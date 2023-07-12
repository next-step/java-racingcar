package racing;

import racing.controller.GameController;
import racing.domain.CarFactory;
import racing.viewer.RacingReader;
import racing.viewer.Viewer;
import racing.domain.GameInfo;

public class RacingApplication {

    public static void main(String[] args) {
        RacingReader racingReader = new RacingReader();
        GameInfo gameInfo = racingReader.inputForReady();
        CarFactory carFactory = CarFactory.getInstance();
        GameController gameController = new GameController(carFactory, new Viewer());
        gameController.startRacing(gameInfo);
    }

}
