package racing;

import java.util.Random;
import racing.model.Cars;
import racing.service.RaceService;
import racing.service.RandomNumberGenerator;
import racing.view.InputView;

public class RacingGameApplication {
    public static void main(String[] args) {
        // 1. INPUT
        InputView inputView = new InputView();
        int carCount = inputView.getCarCount();
        int moveCount = inputView.getMoveCount();

        // 2. GAME
        RaceService raceService = new RaceService();
        Cars cars = raceService.generateCar(carCount, new RandomNumberGenerator());
        raceService.moveCar(cars, moveCount);

        // TODO. 3. OUTPUT
    }
}
