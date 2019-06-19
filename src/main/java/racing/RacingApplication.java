package racing;

import racing.io.InputView;
import racing.model.Car;
import racing.model.RacingGame;
import racing.model.RandomNumberCreator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingApplication {

    public static void main(String[] args) {
        List<Car> cars = createCars();
        int raceCount = getRaceCount();
        RacingGame.of(cars, raceCount).run();

    }

    private static List<Car> createCars() {
        return InputView.getCarNames()
                .stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private static int getRaceCount() {
        return InputView.getRaceCount();
    }
}
