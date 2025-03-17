package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String inputCars = inputView.inputCars();
        int tryCount = inputView.inputTryCount();
        List<Car> cars = new CarsGenerator().generateCars(inputCars);
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(cars, tryCount, resultView);
        racingGame.process(new Random());
    }
}
