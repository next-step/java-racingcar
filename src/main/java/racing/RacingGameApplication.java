package racing;

import static racing.view.InputView.getCarName;
import static racing.view.InputView.getMoveCount;

import java.util.List;
import racing.domain.Cars;
import racing.service.RaceService;
import racing.service.RandomNumberGenerator;
import racing.view.OutputView;

public class RacingGameApplication {
    private static final int RAND = 10;

    public static void main(String[] args) {
        List<String> carNames = getCarName();
        int moveCount = getMoveCount();

        RaceService raceService = new RaceService(new RandomNumberGenerator(RAND));
        Cars cars = raceService.generateCar(carNames);

        OutputView.printResultLabel();
        for (int i = 0; i < moveCount; i++) {
            cars = raceService.moveCar(cars);
            OutputView.printResult(cars);
        }
        OutputView.printWinner(cars.getWinner());
    }
}
