package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;


public class Main {

    public static void main(String[] args) {

        int carCount = InputView.getCarCount();
        int gameRound = InputView.getGameRound();

        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = Car.newInstance();
        }

        ResultView.printBanner();
        new RacingGame(gameRound, cars).play();
    }
}
