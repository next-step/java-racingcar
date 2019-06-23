package racingcar;

import racingcar.InputView;
import racingcar.RacingGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingMain {

    static Map<Integer, List<Car>> gameRecord = new HashMap<>();

    public static void main(String[] args) {
        int numberOfCars = InputView.inputNumberOfCars();
        int numberOfGames = InputView.inputNumberOfGames();

        RacingGame racingGame = new RacingGame(numberOfCars, numberOfGames);
        racingGame.carsLineup();
        gameRecord = racingGame.gameStart();
        ResultView.printResult(gameRecord);
    }
}