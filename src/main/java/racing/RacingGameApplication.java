package racing;

import java.util.List;
import java.util.Random;
import racing.model.Cars;
import racing.service.RaceService;
import racing.service.RandomNumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        // 1. INPUT
        InputView inputView = new InputView();
        int carCount = inputView.getCarCount();
        int moveCount = inputView.getMoveCount();

        // 2. GAME
        RaceService raceService = new RaceService();
        Cars cars = raceService.generateCar(carCount, new RandomNumberGenerator());
        StringBuilder gameStatus = new StringBuilder();

        for (int i = 0; i < moveCount; i++) {
            raceService.moveCar(cars);
            appendCarPosition(cars, gameStatus);
            gameStatus.append("\n");
        }

        // 3. OUTPUT
        OutputView outputView = new OutputView();
        outputView.printResult(gameStatus.toString());
    }

    private static void appendCarPosition(Cars cars, StringBuilder gameStatus) {
        for (Integer position : cars.getPositions()) {
            gameStatus.append("-".repeat(position)).append("\n");
        }
    }
}
