package car.controller;

import car.model.Cars;
import car.view.InputView;
import car.model.RandomNumberGenerator;
import car.view.ResultView;

public class GameController {

    private static final InputParser inputParser = new InputParser();
    private final RandomNumberGenerator randomNumberGenerator;

    public GameController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startRacingGame() {
        Cars cars = new Cars(inputParser.parseUserInputByDelimiter(InputView.inputCarNames()));
        playGame(InputView.inputNumberOfGames(), cars);
        ResultView.outputFinalGameResult(cars.findTiedWinnerCarNames());
    }

    private void playGame(Integer numberOfGames, Cars cars) {
        int totalCarCount = cars.getTotalCarCount();
        for (int i = 0; i < numberOfGames; i++) {
            cars.playGameByCars(randomNumberGenerator.makeRandomNumbers(totalCarCount));
            ResultView.outputEachGameResult(cars.getCars());
        }
    }
}
