import car.Car;
import utils.CarGenerator;
import utils.InputView;
import utils.OutputView;
import utils.RandomNumberGenerator;

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

        IntStream.range(0, tryCount).forEach(i -> {
            cars.forEach(car -> car.move(RandomNumberGenerator.generate()));
            OutputView.displayRoundResult(cars);
        });
    }
}
