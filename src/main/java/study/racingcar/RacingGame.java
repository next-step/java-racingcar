package study.racingcar;

import study.racingcar.car.Car;
import study.racingcar.configuration.GameConfiguration;
import study.racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private static Scanner scanner = new Scanner(System.in);

    GameConfiguration gameConfiguration;
    ResultView resultView;
    List<Car> cars;

    public RacingGame(GameConfiguration gameConfiguration, ResultView resultView) {
        this.gameConfiguration = gameConfiguration;
        this.resultView = resultView;
    }


    // 게임진행
    public GameResult startGame() {

        initGame();

        for (int tries = 0; gameConfiguration.doMoreTry(tries); tries++) {
            cars.stream().forEach(Car::move);
            resultView.displayResult(cars);
            System.out.println();
        }

        return new GameResult(cars);
    }

    private void initGame() {
        this.cars = gameConfiguration.initCars();
    }

}
