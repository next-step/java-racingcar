package step4;

import java.util.List;
import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNamesInput();
        int rounds = InputView.getRoundsInput();

        List<Car> carList = CarFactory.createCars(carNames);
        RandomMovingStrategy movingStrategy = new RandomMovingStrategy(new Random());
        Cars cars = new Cars(carList, movingStrategy);

        RacingGame racingGame = new RacingGame(cars, rounds);
        racingGame.startGame();
        String raceProgress = racingGame.getRaceProgress();
        List<String> winners = racingGame.winners();

        OutputView.printRaceProgress(raceProgress);
        OutputView.printWinners(winners);
    }
}
