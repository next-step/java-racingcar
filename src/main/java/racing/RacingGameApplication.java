package racing;

import static racing.view.InputView.getCarCount;
import static racing.view.InputView.getMoveCount;

import racing.model.Cars;
import racing.service.RaceService;
import racing.service.RandomNumberGenerator;
import racing.view.OutputView;

public class RacingGameApplication {
    private static final int RAND = 10;

    public static void main(String[] args) {
        int carCount = getCarCount();
        int moveCount = getMoveCount();

        RaceService raceService = new RaceService(new RandomNumberGenerator(RAND));
        Cars cars = raceService.generateCar(carCount);

        OutputView.printResultLabel();
        for (int i = 0; i < moveCount; i++) {
            raceService.moveCar(cars);
            OutputView.printResult(cars);
        }
    }
}
