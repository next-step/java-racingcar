import car.Cars;
import car.WinnerDeterminer;
import utils.*;

import java.util.stream.IntStream;

public class RacingCar {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        String[] carNames = InputView.inputCarNames();
        int tryCount = InputView.inputTryCount();

        Cars cars = new Cars(CarGenerator.generateCars(carNames));

        OutputView.displayResultMessage();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        IntStream.range(0, tryCount).forEach(i -> {
            cars.moveAll(numberGenerator);
            OutputView.displayRoundResult(cars.getCars());
        });

        OutputView.displayWinners(WinnerDeterminer.findWinners(cars));
    }
}
