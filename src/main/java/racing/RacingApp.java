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
        int attemptCount = InputView.getNumberOfAttempts();
        List<Car> cars = Racing.enroll(inputNames);
        Racing racing = new Racing(cars, attemptCount);
        racing.start();
        ResultView.showWinners(racing.winners());
    }
}
