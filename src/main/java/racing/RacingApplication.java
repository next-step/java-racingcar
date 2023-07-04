package racing;

import racing.controller.Host;
import racing.factory.CarFactory;
import racing.io.RacingReader;
import racing.io.Viewer;
import racing.model.GameInfo;

public class RacingApplication {

    public static void main(String[] args) {
        RacingReader racingReader = new RacingReader();
        GameInfo gameInfo = racingReader.startGame();
        CarFactory carFactory = CarFactory.getInstance();
        Host host = new Host(gameInfo, carFactory, new Viewer());
        host.startRacing();
    }

}
