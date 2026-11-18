package step3;

import java.time.Duration;

public class MainCarRacing {

    public static void main(String[] args) throws InterruptedException {

        int carCount = InputView.readCarCount();
        int tryCount = InputView.readTryCount();

        CarRacing carRacing = new CarRacing(carCount, tryCount, new RandomMoveStrategy());

        ResultView.printRaceResult(carRacing, Duration.ofMillis(500));
    }
}
