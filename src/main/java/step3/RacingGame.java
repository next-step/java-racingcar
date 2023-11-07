package step3;

import step3.dto.RacingCar;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Random;

public class RacingGame {

    static RacingCar[] racingCars;

    public static void gameStart() {
        int carNum = InputView.askNumberOfCars();
        int attemptNum = InputView.askNumberOfAttempts();

        // 초기화
        racingCars = new RacingCar[carNum];
        for (int carNo = 0; carNo < carNum; carNo++) {
            racingCars[carNo] = new RacingCar();
        }

        // 레이싱 진행
        ResultView.title();
        for (int attempt = 0; attempt < attemptNum; attempt++) {
            racing();
            ResultView.printResult(racingCars);
        }
    }

    private static void racing() {
        for (RacingCar racingCar : racingCars) {
            moveCar(racingCar);
        }
    }

    private static void moveCar(RacingCar racingCar) {
        int movingCondition = new Random().nextInt(10);
        if (RacingRule.canMove(movingCondition)) {
            racingCar.move();
        }
    }

}
