import car.Car;
import car.Cars;
import utils.*;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCar {
    public static void main(String[] args) {
        play();
    }

    private static void play() {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Cars cars = new Cars(CarGenerator.generateCars(carCount));

        OutputView.displayResultMessage();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        IntStream.range(0, tryCount).forEach(i -> {
            cars.moveAll(numberGenerator);
            OutputView.displayRoundResult(cars.getCars());
        });
    }
}
