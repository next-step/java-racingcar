package racingcar;

import racingcar.broadcast.Broadcast;
import racingcar.broadcast.CLIBroadcast;
import racingcar.movingstrategy.RandomMovingStrategy;
import racingcar.io.RacingCarScanner;

public class RacingcarApplication {

    public static void main(String[] args) {
        RacingCarScanner racingCarScanner = new RacingCarScanner();

        int carCount = racingCarScanner.carCount();
        int labCount = racingCarScanner.labCount();

        Broadcast broadcast = new CLIBroadcast();
        RacingGame racingGame = new RacingGame(labCount, broadcast);
        for (int i=0 ; i<carCount ; i++) {
            racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        }

        racingGame.start();
    }

}
