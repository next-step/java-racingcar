package step3.game;

import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;

import static step3.game.RacingCarInfo.getCars;
import static step3.game.RandomGenerator.getRandomValue;

public class RacingCarGame {

    public static final int MOVE_CRITERIA = 4;

    public static void game() {
        RacingCarInfo game = getGameInput();
        OutputView.printResult();
        for (int i = 0; i < game.tryCount; i++) {
            takeTurn(game.cars);
        }
        InputView.closeScanner();
    }

    private static RacingCarInfo getGameInput() {
        return getCars(parseInt(inputCarCount()));
    }

    public static String inputCarCount() {
        return InputView.inputCarCount();
    }

    public static String inputTryCount() {
        return InputView.inputTryCount();
    }

    private static void takeTurn(List<Car> cars) {
        for (Car car : cars) {
            makeMove(car);
        }
        OutputView.endOfThisTurn();
    }

    private static void makeMove(Car car) {
        if (isMove(getRandomValue())) {
            car.move();
        }
        OutputView.printCarDistance(car.getDistance());
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERIA;
    }
}
