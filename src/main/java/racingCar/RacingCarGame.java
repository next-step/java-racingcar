package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {

    private static int MOVE_CONDITION_NUMBER = 4;
    private final String PRINT_EXECUTION_RESULT = "실행 결과";
    private final ResultView resultView = new ResultView();
    private NumberUtil numberUtil;

    public RacingCarGame() {
        this.numberUtil = new NumberUtil();
    }

    public RacingCarGame(NumberUtil numberUtil) {
        this.numberUtil = numberUtil;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    public void race(List<RacingCar> racingCars) {
        System.out.println(PRINT_EXECUTION_RESULT);
        for (RacingCar car : racingCars) {
            if (isMovable(numberUtil.getRandomInt())) {
                car.moveForward();
            };
        }
        resultView.printRaceCondition(racingCars);
    }
}
