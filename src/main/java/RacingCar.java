import car.Car;
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

        List<Car> cars = CarGenerator.generateCars(carCount);
        OutputView.displayResultMessage();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        IntStream.range(0, tryCount).forEach(i -> {
            cars.forEach(car -> car.move(numberGenerator));
            OutputView.displayRoundResult(cars);
        });
    }
}
