package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.carCountView(scanner);
        int tryCount = inputView.tryCountView(scanner);

        RacingGame racingGame = new RacingGame();
        racingGame.generateCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            racingGame.race();
        }
    }
}
