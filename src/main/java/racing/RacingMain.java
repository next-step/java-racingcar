package racing;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingMain {
    public static void main(String[] args) {
        List<Car> cars = InputView.getCarNames();
        int count = InputView.getTryNo();


        RacingGame racingGame = new RacingGame(cars, new Random());
        for (int i = 0; i < count; i++) {
            racingGame.startRace();
            ResultView.printCarsLocation(racingGame);
        }

        ResultView.printRacingWinners(racingGame.getRacingWinners());
    }
}
