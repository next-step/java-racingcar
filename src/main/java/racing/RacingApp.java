package racing;

import racing.car.Car;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;
import java.util.Random;

public class RacingApp {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String inputNames = InputView.getInputNames();
        int numberOfAttempt = InputView.getNumberOfAttempts();
        Racing racing = new Racing();
        String[] inputCarNames = inputNames.split(",");
        List<Car> cars = racing.ready(inputCarNames);
        for (int i = 0; i < numberOfAttempt; ++i) {
            go(cars);
            ResultView.nextAttempt();
        }
    }

    private static void go(List<Car> cars) {
        for (Car car : cars) {
            int input = random.nextInt(10);
            car.move(input);
            ResultView.showCurrentPosition(car);
        }
    }
}
