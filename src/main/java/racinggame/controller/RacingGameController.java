package racinggame.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import racinggame.domain.Car;
import racinggame.view.InputView;
import racinggame.domain.MovingValidator;
import racinggame.domain.RacingGame;
import racinggame.domain.strategy.RandomNumberMovingStrategy;
import racinggame.view.ResultView;

public class RacingGameController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = InputView.carCount(scanner);
        int number = InputView.playCount(scanner);
        List<Car> cars = createCars(value);
        RacingGame racingGame = new RacingGame(cars);
        ResultView.br();
        ResultView.resultSign();
        for (int i = 0; i < number; i++) {
            racingGame.play();
            ResultView.report(racingGame.report());
        }
    }

    private static List<Car> createCars(String value) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(value); i++) {
            Car car = new Car(new MovingValidator(new RandomNumberMovingStrategy(new Random())));
            cars.add(car);
        }
        return cars;
    }

}
