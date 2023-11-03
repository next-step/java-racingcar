package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;
import java.util.Random;

public class RacingApp {
    public static void main(String[] args) {
        int numberOfCar = InputView.getNumberOfCars();
        int numberOfAttempt = InputView.getNumberOfAttempts();
        Racing racing = new Racing();
        List<Car> cars = racing.ready(numberOfCar);
        for (int i = 0; i < numberOfAttempt; ++i) {
            go(cars);
            ResultView.nextAttempt();
        }
    }

    private static void go(List<Car> cars) {
        for (Car car : cars) {
            Random random = new Random();
            int input = random.nextInt(10);
            car.move(input);
            ResultView.showCurrentPosition(car);
        }
    }
}
