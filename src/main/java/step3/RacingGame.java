package step3;

import step3.domain.RacingCar;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Random;

public class RacingGame {

    public static void gameStart() {
        int carNum = InputView.askNumberOfCars();
        int attemptNum = InputView.askNumberOfAttempts();

        // 초기화
        RacingCar[] racingCars = new RacingCar[carNum];
        initRacingCars(racingCars);

        // 레이싱 진행
        ResultView.title();
        for (int attempt = 0; attempt < attemptNum; attempt++) {
            racing(racingCars);
            ResultView.printResult(racingCars);
        }
    }

    private static void initRacingCars(RacingCar[] racingCars) {
        for (int carNo = 0; carNo < racingCars.length; carNo++) {
            racingCars[carNo] = new RacingCar();
        }
    }

    private static void racing(RacingCar[] racingCars) {
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
