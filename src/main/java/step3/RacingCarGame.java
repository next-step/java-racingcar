package step3;

import step3.util.InputView;
import step3.util.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    static int carCount;
    static int attemptCount;
    static List<RacingCar> cars = new ArrayList<>();
    static MovingStrategy strategy = new RandomNumMovingStrategy();

    public static void main(String[] args) {
        carCount = InputView.inputCarCount();
        attemptCount = InputView.inputAttemptCount();

        makeCars();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            race();
            System.out.println();
        }
    }

    private static void makeCars() {
        for (int i = 0; i < carCount; i++) {
            cars.add(new RacingCar());
        }
    }

    private static void race() {
        for (RacingCar car : cars) {
            car.move(strategy);
            ResultView.showResult(car.getDistance());
        }
    }
}
