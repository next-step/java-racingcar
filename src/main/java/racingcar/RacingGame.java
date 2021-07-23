package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MAX_VALUE = 10;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] carNames = inputView.insertCarNames();
        int tryNumber = inputView.getNumberOfTry();

        List<Car> cars = Car.createCars(carNames);

        for(int i = 0; i < tryNumber; i++) {
            printAll(cars);
        }

        Collections.reverse(cars);

        Winner winner = Winner.of(Winner.resultPointOfFirst(cars));

        winner.extracted(resultView, cars, winner);
    }

    public static void printAll(List<Car> cars) {
        ResultView resultView = new ResultView();
        for(Car car: cars) {
            Random random = new Random();

            int randomNumber = random.nextInt(MAX_VALUE);
            int moveNumber = car.move(randomNumber);

            resultView.print(car.getName(), moveNumber);
        }
        System.out.println();
    }
}
