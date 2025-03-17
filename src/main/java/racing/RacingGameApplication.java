package racing;

import static racing.view.InputView.getCarCount;
import static racing.view.InputView.getMoveCount;
import static racing.view.OutputView.printResult;

import racing.model.Cars;
import racing.service.RaceService;
import racing.service.RandomNumberGenerator;

public class RacingGameApplication {
    private static final int RAND = 10;

    public static void main(String[] args) {
        // 1. INPUT
        int carCount = getCarCount();
        int moveCount = getMoveCount();

        // 2. GAME
        RaceService raceService = new RaceService(new RandomNumberGenerator(RAND));
        Cars cars = raceService.generateCar(carCount);
        StringBuilder gameStatus = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            raceService.moveCar(cars);
            appendCarPosition(cars, gameStatus);
            gameStatus.append("\n");
        }

        // 3. OUTPUT
        printResult(gameStatus.toString());
    }

    private static void appendCarPosition(Cars cars, StringBuilder gameStatus) {
        for (Integer position : cars.getPositions()) {
            gameStatus.append("-".repeat(position)).append("\n");
        }
    }
}
