package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        int carCount = inputView.inputCarCount();
        int tryCount = inputView.inputTryCount();
        List<Car> cars = new CarGenerator().generateCar(carCount);
        ResultView resultView = new ResultView();
        RacingCarGame racingGame = new RacingCarGame(cars, tryCount, resultView);
        racingGame.startGame(new Random());
    }
}