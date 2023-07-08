package racing;

import racing.controller.GameController;
import racing.factory.CarFactory;
import racing.io.RacingReader;
import racing.io.Viewer;
import racing.model.GameInfo;

public class RacingApplication {

    public static void main(String[] args) {
        RacingReader racingReader = new RacingReader();
        GameInfo gameInfo = racingReader.inputForReady();
        CarFactory carFactory = CarFactory.getInstance();
        GameController gameController = new GameController(carFactory, new Viewer());
        gameController.startRacing(gameInfo);
    }

}
