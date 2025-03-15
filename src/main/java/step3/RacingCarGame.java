package step3;

import step3.view.InputView;
import step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static final Random RANDOM = new Random();
    private static final Integer START = 0;

    public static String inputCarCount() {
        return InputView.inputCarCount();
    }

    public static String inputTryCount() {
        return InputView.inputTryCount();
    }

    static void game() {
        RacingCarInfo game = getGameInput();
        OutputView.printResult();
        for (int i = 0; i < game.tryCount; i++) {
            takeTurn(game.cars);
        }
        InputView.closeScanner();
    }

    private static RacingCarInfo getGameInput() {
        int carCount = parseInt(inputCarCount());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(START));
        }
        int tryCount = parseInt(inputTryCount());
        return new RacingCarInfo(cars, tryCount);
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

    private static Integer parseInt(String input) {
        return Integer.parseInt(input);
    }

    public static Integer getRandomValue() {
        return RANDOM.nextInt(10);
    }

    public static Boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
