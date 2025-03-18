package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MOVABLE_THRESHOLD = 4;
    private static final int DEFAULT_MOVING_DISTANCE = 1;
    private static final int RANDOM_BOUND = 10;

    private static final Random random = new Random();

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.getCarCount();
        int attempts = inputView.getAttempts();

        ResultView resultView = new ResultView();

        System.out.println("\n실행 결과");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(MOVABLE_THRESHOLD));
        }

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int randomInt = random.nextInt(RANDOM_BOUND);
                car.moveOrStop(randomInt, DEFAULT_MOVING_DISTANCE);
            }
            resultView.printCurrentRacingProgress(cars);
        }
    }
}
